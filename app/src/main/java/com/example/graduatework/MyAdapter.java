package com.example.graduatework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<LinkList> array;

    public MyAdapter(Context context, ArrayList<LinkList> array) {
        this.context = context;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        TextView link = convertView.findViewById(R.id.link);
        TextView short_link = convertView.findViewById(R.id.short_link);

        link.setText(array.get(position).getLink());
        short_link.setText("Short link " + array.get(position).getShort_link());

        return convertView;
    }
}
