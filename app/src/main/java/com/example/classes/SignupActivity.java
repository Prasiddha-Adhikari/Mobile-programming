package com.example.classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class SignupActivity extends AppCompatActivity {
    private Toolbar toolbar;
    String email = "";
    AppCompatButton btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);
        btnSignup = findViewById(R.id.btn_login);
        email= getIntent().getStringExtra("Email");
        Log.d("Email Address",email);
        Toast.makeText(this,email,Toast.LENGTH_LONG).show();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Result","Result Return");
                setResult(RESULT_OK,intent);
                initToolbar();
                finish();

            }
        });

    }
    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("SignUp");

    }

}