package com.example.nutritionking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }

    public void userRegister(View view)
    {
        Intent i=new Intent(RegisterPage.this,Login.class);
        startActivity(i);
    }




}

