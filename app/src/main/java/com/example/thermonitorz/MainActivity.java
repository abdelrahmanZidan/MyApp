package com.example.thermonitorz;

import android.content.Intent;
import android.opengl.EGLExt;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private Button Login;
    private Button Register;
    private FirebaseAuth Connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        Connect=FirebaseAuth.getInstance();
        Email = findViewById(R.id.edit_text_email);
        Password = findViewById(R.id.edit_text_password);

        Register=findViewById(R.id.button_register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        Login = findViewById((R.id.button_login));
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mail=Email.getText().toString();
                String Pass=Password.getText().toString();
                if(TextUtils.isEmpty(Mail)){
                    Toast.makeText(getApplicationContext(),"Please enter your Email",Toast.LENGTH_SHORT).show();
                    if (TextUtils.isEmpty(Pass)) {
                        Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_SHORT).show();
                    }
                }
                if((!TextUtils.isEmpty(Mail))&&(!TextUtils.isEmpty(Pass))){
                    Connect.signInWithEmailAndPassword(Mail,Pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(MainActivity.this,List.class);
                                startActivity(intent);
                                finish();


                            }
                            else{
                                Toast.makeText(MainActivity.this,"INVALID DETAILS",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

            }}
        });

    }

}


