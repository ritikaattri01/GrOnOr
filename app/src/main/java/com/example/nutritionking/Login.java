package com.example.nutritionking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


    public class Login extends AppCompatActivity {
        Button login;
        EditText username;
        EditText password;
        TextView newuser;
        String u;
        String p;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            username=findViewById(R.id.etusername);
            newuser=findViewById(R.id.tvnew);
            password=findViewById(R.id.etpassword);
            login=findViewById(R.id.blogin);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validate()){
                        doLogin();
                    }

                }

                private boolean validate() {
                    u = username.getText().toString();
                    p = password.getText().toString();
                    if(u.isEmpty()||p.isEmpty()) {
                        Toast.makeText(Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    else
                        return true;
                }

            });

            newuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Login.this,RegisterPage.class);
                    startActivity(intent);
                }
            });
        }

        public void doLogin()
        {
            Toast.makeText(Login.this, "LoginSuccessful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }


