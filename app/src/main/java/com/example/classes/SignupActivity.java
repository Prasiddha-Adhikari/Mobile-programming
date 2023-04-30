package com.example.classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class SignupActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edt_Email,edt_Pass,edt_FirstName,edt_LastName,edt_Address,edt_contact,edt_ConfirmPass;
    String email = "";
    AppCompatButton btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);
        edt_Email=findViewById(R.id.edt_Email);
        edt_Pass=findViewById(R.id.edt_Pass);
        edt_FirstName=findViewById(R.id.edt_FirstName);
        edt_LastName=findViewById(R.id.edt_LastName);
        edt_Address=findViewById(R.id.edt_Address);
        edt_contact=findViewById(R.id.edt_contact);
        edt_ConfirmPass=findViewById(R.id.edt_ConfirmPass);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String Email = edt_Email.getText().toString();
//                String Pass = edt_Pass.getText().toString();
//                String FirstName = edt_FirstName.getText().toString();
//                String LastName = edt_LastName.getText().toString();
//                String Contact = edt_contact.getText().toString();
//                String Address = edt_Address.getText().toString();
//                String ConfirmPassword = edt_ConfirmPass.getText().toString();

                if (edt_FirstName.getText().toString().isEmpty()||edt_LastName.getText().toString().isEmpty()||edt_Email.getText().toString().isEmpty()||
                        edt_Pass.getText().toString().isEmpty()||edt_contact.getText().toString().isEmpty()||edt_ConfirmPass.getText().toString().isEmpty()||edt_Address.getText().toString().isEmpty()){
                Toast.makeText(SignupActivity.this,"Please Fill all the field.",Toast.LENGTH_SHORT).show();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(edt_Email.getText().toString()).matches()) {
                    Toast.makeText(SignupActivity.this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                } else if (!edt_Pass.getText().toString().equals(edt_ConfirmPass.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}