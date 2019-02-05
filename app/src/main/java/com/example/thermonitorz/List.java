package com.example.thermonitorz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String items []=new String[]{"Oufa","agda3 wa7ed","A7sn wa7ed","a7sn TA","kefaya kda","twsal bel salama","rabna ma3ak","zidan :D"};
        ListView list=(ListView)findViewById(R.id.list);
        ListAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(List.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }
}
