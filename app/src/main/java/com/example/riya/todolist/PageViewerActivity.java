package com.example.riya.todolist;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by riya on 9/11/16.
 */
public class PageViewerActivity extends AppCompatActivity {
    private int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_viewer);

        pos =  Integer.parseInt((String)savedInstanceState.getSerializable("position"));


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageViewerAdapter(this));
        viewPager.setCurrentItem(pos);

        
    }
}
