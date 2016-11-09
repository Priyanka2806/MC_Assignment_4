package com.example.riya.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<ToDoList> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private ImageView mAddIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("To Do List");
        setSupportActionBar(toolbar);


        DBClass db = new DBClass(this);
        itemList = db.getCompleteToDoList();


        mAddIcon = (ImageView) findViewById(R.id.add_icon);

        mAddIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(view.getContext(), AddTaskActivity.class);
                startActivityForResult(addIntent, 1);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MyAdapter(itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareListData();
    }

    private void prepareListData() {

        ToDoList item = new ToDoList("ATM", "Today" , "Withdraw cash from ATM");
        itemList.add(item);

        item = new ToDoList("Office", "2 days ago", "Complete office documents & presentations.");
        itemList.add(item);

        item = new ToDoList("ABC", "Yesterday", "Task 3");
        itemList.add(item);

        item = new ToDoList("DEF", "Today", "Task 4");
        itemList.add(item);

        item = new ToDoList("GHI", "Today", "Task 5");
        itemList.add(item);

        item = new ToDoList("JKL", "Today", "Task 6");
        itemList.add(item);

        item = new ToDoList("LMN", "Today", "Task 7");
        itemList.add(item);

        item = new ToDoList("OPQ", "Today", "Task 8");
        itemList.add(item);

        item = new ToDoList("RST", "Today", "Task 9");
        itemList.add(item);

        item = new ToDoList("UVW", "Today", "Task 10");
        itemList.add(item);

        item = new ToDoList("XYZ", "Today", "Task 11");
        itemList.add(item);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == Activity.RESULT_CANCELED) {
                DBClass db = new DBClass(this);
                itemList = db.getCompleteToDoList();
            }
        }
    }


}