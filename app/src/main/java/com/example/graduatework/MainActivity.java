package com.example.graduatework;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    ArrayList<LinkList> linkedList = new ArrayList<>();
    EditText short_link, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = findViewById(R.id.list_of_short_link);
        short_link = findViewById(R.id.short_link);
        link = findViewById(R.id.link);
        myAdapter = new MyAdapter(this, linkedList);
        listview.setAdapter(myAdapter);
    }

    public void onClick(View v) {
        linkedList.add(new LinkList(link.getText().toString(), short_link.getText().toString()));
        myAdapter.notifyDataSetChanged();
        link.setText("");
        short_link.setText("");
    }
}