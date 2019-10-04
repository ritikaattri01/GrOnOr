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
        //initilizing
        Button login;
        EditText username;
        EditText password;
        TextView newuser;
        String u;
        String p;
        //onCreate method & link java class with activity
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            username=findViewById(R.id.etusername);
            newuser=findViewById(R.id.tvnew);
            password=findViewById(R.id.etpassword);
            login=findViewById(R.id.blogin);
            //onClickListener for login page
            login.setOnClickListener(new View.OnClickListener() {
                //onClick method have declaration of function which includes working
                @Override
                public void onClick(View view) {
                    if (validate()){
                        doLogin();
                    }

                }
                //For validation
                private boolean validate() {
                    //get string data for username and password
                    u = username.getText().toString();
                    p = password.getText().toString();
                    //checking condition and display some toast massage
                    if(u.isEmpty()||p.isEmpty()) {
                        Toast.makeText(Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                    else
                        return true;
                }

            });
            //for moving login to Register page
            newuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Login.this,RegisterPage.class);
                    startActivity(intent);
                }
            });
        }
         //function defination or working
        public void doLogin()
        {
            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, BottomNav.class);
            startActivity(intent);
        }
    }


