package com.example.thermonitorz;

import android.content.Intent;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends AppCompatActivity {
    String items []=new String[]{"C++","JavaScript","Gmail","Java","Yahoo","Pyhtone","C#"};
    int Images[]={R.drawable.cpluss,R.drawable.javasc,R.drawable.gmail,R.drawable.java,R.drawable.yahoo,R.drawable.phythone,R.drawable.conly};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list = (ListView) findViewById(R.id.ListView);
        CustomAdapter customAdapter=new CustomAdapter();
        //ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(List.this, ThirdActivity.class);
                startActivity(intent);
            }

        });
    }


    class CustomAdapter extends  BaseAdapter {
        @Override
        public int getCount() {
            return  Images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView =getLayoutInflater().inflate(R.layout.customlayout ,null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
            TextView textView_items=(TextView)convertView.findViewById(R.id.textView_items);

            imageView.setImageResource(Images[position]);
            textView_items.setText(items[position]);



            return convertView;
        }
    }
    }

