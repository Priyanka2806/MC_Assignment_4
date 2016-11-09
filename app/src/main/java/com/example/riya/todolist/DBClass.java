package com.example.riya.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riya on 9/11/16.
 */
public class DBClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database name
    public static final String DATABASE_NAME = "ToDoDatabase";
    //Table name
    public static final String TABLE_NAME = "task_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DETAILS = "details";
    public static final String COLUMN_DATE = "date";

    //DBClass constructor
    public DBClass(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    //Creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_TODO=
                "create table " + TABLE_NAME +
                        "(" + COLUMN_ID + " INTEGER, " + COLUMN_TITLE + " TEXT PRIMARY KEY, " + COLUMN_DETAILS + " TEXT," + COLUMN_DATE + " TEXT )";
        db.execSQL(CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    // Adding a new task
    public void addNewTask(ToDoList list) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        System.out.println("Todo inside database :"+list.getTitle());
        values.put(COLUMN_TITLE, list.getTitle());
        values.put(COLUMN_DATE, list.getDate());
        values.put(COLUMN_DETAILS, list.getDetails());
        values.put(COLUMN_ID, list.getId());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public ToDoList getRecord(String title) {
        SQLiteDatabase db = this.getReadableDatabase();

        String q1 = "SELECT * FROM " + TABLE_NAME + " WHERE "+COLUMN_TITLE+" = "+title;
        Cursor cursor = db.rawQuery(q1,null);

        if (cursor != null)
            cursor.moveToFirst();

        ToDoList obj = new ToDoList(cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return obj;
    }

    public List<ToDoList> getCompleteToDoList() {
        List<ToDoList> task_list = new ArrayList<ToDoList>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ToDoList todo = new ToDoList();
                todo.setTitle(cursor.getString(0));
                todo.setDetails(cursor.getString(1));
                task_list.add(todo);
            } while (cursor.moveToNext());
        }
        return task_list;
    }
}

