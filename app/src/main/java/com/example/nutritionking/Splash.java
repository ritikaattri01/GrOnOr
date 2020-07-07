package com.example.nutritionking;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {
//onCreate method & link java class with activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // intent method to move from splash page to login page
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                if (user==null)
                {
                    Intent intent=new Intent(Splash.this,Login.class);
                    startActivity(intent);
                    finish();
                }else
                {
                    Intent intent=new Intent(Splash.this,NavDrawer.class);
                    startActivity(intent);
                    finish();
                }
            }
        },1000);

    }
}


