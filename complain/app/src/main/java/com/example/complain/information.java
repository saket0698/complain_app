package com.example.complain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class information extends AppCompatActivity {
    private EditText name,address,imei,product;
    private Button submit;
    FirebaseDatabase rootnode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        name = (EditText)findViewById(R.id.etname);
        address = (EditText)findViewById(R.id.etaddress);
        imei = (EditText)findViewById(R.id.etimei);
        product = (EditText)findViewById(R.id.etproduct);
        submit = (Button)findViewById(R.id.btnsubmit);
                submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("information");

               String username = name.getText().toString();
               String place = address.getText().toString();
               String imeino = imei.getText().toString();
               String prod = product.getText().toString();
               if(username.isEmpty()||place.isEmpty()||imeino.isEmpty()||prod.isEmpty()){
                   Toast.makeText(information.this,"Enter All Details",Toast.LENGTH_SHORT).show();
               }
               else {
                   helper i = new helper(username, place, imeino, prod);
                   reference.child(imeino).setValue(i);
                   Toast.makeText(information.this,"Submitted Successfully",Toast.LENGTH_SHORT).show();

                   Intent j = new Intent(information.this, thanks.class);
                   startActivity(j);
               }
            }
        });
    }
}