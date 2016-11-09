package com.example.riya.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddTaskActivity extends AppCompatActivity {

    private EditText mTitleText;
    private EditText mDetailText;
    private Button mAddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mTitleText = (EditText)findViewById(R.id.editTextTitle);
        mDetailText = (EditText)findViewById(R.id.editTextDetails);

        mAddButton = (Button)findViewById(R.id.addButton);
        final DBClass db  = new DBClass(this);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_text = mTitleText.getText().toString();
                String details_text = mDetailText.getText().toString();
                String date = "Today";

                ToDoList obj = new ToDoList(title_text,date,details_text);
                db.addNewTask(obj);

                Toast.makeText(getApplicationContext(),"TASK ADDED SUCCESSFULLY!!",Toast.LENGTH_SHORT).show();
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();

            }
        });
    }
}

