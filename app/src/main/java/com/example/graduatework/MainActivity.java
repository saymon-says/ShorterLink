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

    ArrayAdapter<String> adapter;
    ArrayList<String> linkedList = new ArrayList<>();
    EditText short_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = findViewById(R.id.list_of_short_link);
        short_link = findViewById(R.id.short_link);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, linkedList);
        listview.setAdapter(adapter);
    }

    public void onClick(View v) {
        linkedList.add(short_link.getText().toString());
        adapter.notifyDataSetChanged();
        short_link.setText("");
    }
}