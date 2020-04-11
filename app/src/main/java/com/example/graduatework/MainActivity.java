package com.example.graduatework;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> linksAdapter;

    Map<String, String> links = new HashMap<>();
    EditText short_link, link;
    Button btn;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.list_of_short_link);
        short_link = findViewById(R.id.short_link);
        link = findViewById(R.id.link);
        btn = findViewById(R.id.btn);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://" + links.get(parent.getAdapter().getItem(position))));
                startActivity(browserIntent);
            }
        });
    }

    public void onClick(View v) {
        if ((link.getText().length() < 4) || (!link.getText().toString().contains("."))) {
            btn.setText("Неверная ссылка");
        } else if (short_link.getText().length() == 0) {
            btn.setText("Укажите сокращение!");
        } else if(links.containsKey(short_link.getText().toString())) {
            btn.setText("Занято");
        } else {
            links.put(short_link.getText().toString(), link.getText().toString());
            setLinkItems();
            link.setText("");
            short_link.setText("");
            btn.setText("Добавлено");
        }
    }

    void setLinkItems() {
        ArrayList linkedList = new ArrayList<>();
        linksAdapter  =  new ArrayAdapter<>(this, R.layout.list_item, R.id.short_link,  linkedList);
        listview.setAdapter(linksAdapter);
        for(Map.Entry<String, String> entry : links.entrySet()) {
            String short_link= entry.getKey();
            String link = entry.getValue();
            linkedList.add(short_link);
        }
    }
}