package com.example.safecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
    private TextView txtusername,txtemployeeid,txtcity;
    private TextView txtSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtusername = findViewById(R.id.txtusername);
        txtemployeeid = findViewById(R.id.txtemployeeid);
        txtcity = findViewById(R.id.txtcity);
        txtSignin=findViewById(R.id.txtSignin);

        this.setTitle("SignUp");


        // Fetch data from the intent passed by QRCodeActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString("EMPLOYEE_ID");
            String place = extras.getString("EMPLOYEE_CITY");
            String fName = extras.getString("EMPLOYEE_FIRST_NAME");
            String lName = extras.getString("EMPLOYEE_LAST_NAME");

            // Set the fetched data to the TextViews
            txtemployeeid.setText("ID: " + id);
            txtcity.setText("Place: " + place);
            txtusername.setText("Name: " + fName + " " +lName);
        }

        txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}