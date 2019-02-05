package com.example.thermonitorz;

import android.content.Intent;
import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = findViewById(R.id.edit_text_email);
        Password = findViewById(R.id.edit_text_password);
        Login = findViewById((R.id.button_login));
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,List.class);
                startActivity(intent);
            }
        });

    }

}


