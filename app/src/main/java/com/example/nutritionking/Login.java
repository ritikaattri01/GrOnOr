package com.example.nutritionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nutritionking.ui.settings.Settings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
        //initilizing
        Button login;
        EditText username;
        EditText password;
        TextView newuser;
        TextView fpassword;
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
            fpassword= findViewById(R.id.fpassword);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validate()){
                        doLogin();
                    }

                }
            });
            newuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Login.this,RegisterPage.class);
                    startActivity(intent);
                }
            });
            fpassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Login.this, Forgot.class);
                    startActivity(intent);
                }
            });
        }

    public void doLogin(){
        Util.showProgress(this);

        FirebaseAuth.getInstance().signInWithEmailAndPassword(u,p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Login.this, "LoginSuccessful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Login.this,NavDrawer.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Util.hideProgress();

                Toast.makeText(Login.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean validate(){
        u = username.getText().toString();
        p = password.getText().toString();
        if(u.isEmpty()||p.isEmpty())
            return false;
        else
            return true;
    }
}
