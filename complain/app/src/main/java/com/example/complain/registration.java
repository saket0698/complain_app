package com.example.complain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
    private EditText email,password;
    private Button register;
    private TextView signin;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = (EditText)findViewById(R.id.etuser_name);
        password = (EditText)findViewById(R.id.etpwd);
        register = (Button)findViewById(R.id.btnregister) ;
        signin = (TextView)findViewById(R.id.tvsignin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(registration.this,MainActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                String user_email = email.getText().toString();
                String user_pwd = password.getText().toString();
                System.out.println(user_email);
                System.out.println(user_pwd);
                if((user_email.isEmpty()||user_pwd.isEmpty())){
                        Toast.makeText(registration.this,"Enter All Details",Toast.LENGTH_SHORT).show();
               }
                else {
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_pwd).addOnCompleteListener(registration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(registration.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(registration.this, "Registration UnSuccessful", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }

        });
        }
    }
