package com.example.riya.todolist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by riya on 9/11/16.
 */
public class PageViewerAdapter extends PagerAdapter {
    private Context mContext;
    private LayoutInflater mLInflater;

    public PageViewerAdapter(Context context) {
        mContext = context;
        mLInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        View thisRowView = mLInflater.inflate(R.layout.activity_to_do_list, collection, false);

        TextView titletext = (TextView) thisRowView.findViewById(R.id.title);
        TextView detailstext = (TextView) thisRowView.findViewById(R.id.details);
        String title = MainActivity.itemList.get(position).getTitle();
        String details = MainActivity.itemList.get(position).getDetails();
        titletext.setText(title);
        if(!details.equals("")) {
            detailstext.setText(details);
        }
        collection.addView(thisRowView);

        return thisRowView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return MainActivity.itemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MainActivity.itemList.get(position).getTitle();
    }



}
