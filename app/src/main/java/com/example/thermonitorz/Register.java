package com.example.thermonitorz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Register extends AppCompatActivity {
    private EditText UserName;
    private EditText Email;
    private EditText Password;
    private EditText ConfirmPassword;
    private FirebaseAuth Connect;
    private Button Reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);
        Connect=FirebaseAuth.getInstance();
        UserName=findViewById(R.id.edit_text_username);
        Email=findViewById(R.id.edit_text_email);
        Password=findViewById(R.id.edit_text_password);
        ConfirmPassword=findViewById(R.id.edit_text_confirmpassword);

        Reg=findViewById(R.id.button_reg);
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NAME=UserName.getText().toString();
                String Mail=Email.getText().toString();
                String Pass=Password.getText().toString();
                String ConfPass=ConfirmPassword.getText().toString();
                if(TextUtils.isEmpty(NAME)){
                    Toast.makeText(getApplicationContext(),"Please enter your Name",Toast.LENGTH_SHORT).show();
                    if (TextUtils.isEmpty(Mail)) {
                        Toast.makeText(getApplicationContext(), "Please enter your Email", Toast.LENGTH_SHORT).show();
                        if(TextUtils.isEmpty(Pass)){
                            Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_SHORT).show();
                            if (TextUtils.isEmpty(ConfPass)) {
                                Toast.makeText(getApplicationContext(), "Please enter your Confirmed Password", Toast.LENGTH_SHORT).show();
                                if(!ConfPass.contentEquals(Pass)){
                                    Toast.makeText(getApplicationContext(), "Please enter your Confirmed Password Right", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
                else{
                    Connect.createUserWithEmailAndPassword(Mail,Pass)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(),"Registraion is successful",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Register.this,List.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"Registraion is not successful",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });





                        }}





        });


    }
}
