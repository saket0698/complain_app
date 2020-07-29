package com.example.complain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
        private TextView signup;
        private Button login;
        private EditText userid,pwd;
        private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        signup = (TextView)findViewById(R.id.tvsignup);
        login = (Button) findViewById(R.id.btnlogin);
        userid = (EditText)findViewById(R.id.etuser_name);
        pwd = (EditText)findViewById(R.id.etpwd);
        if(firebaseAuth.getCurrentUser()!=null){
            Intent intent = new Intent(MainActivity.this, category.class);
            startActivity(intent);

        }
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,registration.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = userid.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                if(email.isEmpty()&&pass.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter all the credentials",Toast.LENGTH_SHORT).show();

                }


                else if(email.isEmpty()) {
                    userid.setError("Enter Email");
                }
                   else if(pass.isEmpty()){
                      pwd.setError("Enter Password");

                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(MainActivity.this, category.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                            }
                        }


                    });
                }


            }
        });
    }
}