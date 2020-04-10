package com.example.graduatework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    ArrayList linkedList = new ArrayList<>();
    EditText short_link, link;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = findViewById(R.id.list_of_short_link);
        short_link = findViewById(R.id.short_link);
        link = findViewById(R.id.link);
        btn = findViewById(R.id.btn);
        myAdapter = new MyAdapter(this, linkedList);
        listview.setAdapter(myAdapter);
    }

    public void onClick(View v) {
        if (link.getText().length() < 4) {
            btn.setText("Ссылка короче 4х символов");
            return;
        } else if (short_link.getText().length() == 0) {
            btn.setText("Укажите сокращение!");
            return;
        } else {
            linkedList.forEach((n) -> System.out.println(n.toString()));
            if (linkedList.equals(short_link.getText().toString())) {
                linkedList.add(new LinkList(link.getText().toString(), short_link.getText().toString()));
                myAdapter.notifyDataSetChanged();
                link.setText("");
                short_link.setText("");
                btn.setText("Добавлено");
            } else {
                btn.setText("Занято");
                return;
            }
        }
    }
}