package com.example.classes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edt_Email,edt_Pass;
    private AppCompatButton btn_login;
    private TextView txt_forgot, txt_Signup, txt_welcome;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initToolbar();
        findView();
    }
    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Login");

    }
    private void findView(){
        edt_Email = findViewById(R.id.edt_Email);
        edt_Pass= findViewById(R.id.edt_pass);
        btn_login = findViewById(R.id.btn_login);
        txt_welcome = findViewById(R.id.txt_welcome);
        txt_forgot = findViewById(R.id.txt_forgot);
        txt_Signup = findViewById(R.id.txt_Signup);
        btn_login.setOnClickListener(this);
        txt_Signup.setOnClickListener(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_Email.getText().toString().isEmpty()&&edt_Pass.getText().toString().isEmpty()){
        Toast.makeText(LoginActivity.this,"username and password is empty",Toast.LENGTH_LONG).show();
                }
                else if(edt_Pass.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this,"password is empty",Toast.LENGTH_LONG).show();
                }
                else if(edt_Email.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Username is empty",Toast.LENGTH_LONG).show();
                }
                else{

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_login){

        }
        else if(view.getId()==R.id.txt_Signup){
//            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
//            intent.putExtra("Email",edt_Email.getText().toString().trim());
//            intent.putExtra("Email","Prasiddha");
//            startActivity(intent);
//            finish();

            Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
            intent.putExtra("Email", "Email Address");
            signupActivityLauncher.launch(intent);
//            startActivityForResult(intent,100);

        }

    }
    ActivityResultLauncher<Intent> signupActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK){
                        //there is no request code
                        Intent data = result.getData();
                        Toast.makeText(LoginActivity.this, data.getStringExtra("Result"),Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (requestCode==100&& resultCode==RESULT_OK){
            Toast.makeText(this, data.getStringExtra("Result"),Toast.LENGTH_SHORT).show();

        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}