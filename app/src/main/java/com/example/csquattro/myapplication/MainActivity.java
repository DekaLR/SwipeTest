package com.example.csquattro.myapplication;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout sLayout;
    ListView listview;
    Button button;
    EditText text;
    ArrayAdapter listadapter;
    List<String> LIST = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LIST.add("제 1번째");
        LIST.add("제 2번째");
        LIST.add("제 3번째");
//
        button = (Button) findViewById(R.id.button);
        text = (EditText) findViewById(R.id.text);
        sLayout = (SwipeRefreshLayout) findViewById(R.id.swipelayout);
        listview = (ListView) findViewById(R.id.listview);

        listadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST);

        sLayout.setColorSchemeColors(Color.parseColor("#111111"));
        sLayout.setOnRefreshListener(MainActivity.this);

        listview.setAdapter(listadapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LIST.add(text.getText().toString());
            }
        });
    }

    @Override
    public void onRefresh() {
        listadapter.notifyDataSetChanged();
        listview.invalidate();
        sLayout.setRefreshing(false);
    }

}
