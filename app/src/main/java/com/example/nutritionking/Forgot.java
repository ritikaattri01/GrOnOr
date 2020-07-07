package com.example.nutritionking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot extends AppCompatActivity {
EditText mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        mail=findViewById(R.id.emaill);
        findViewById(R.id.pw)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String email=mail.getText().toString();
                        if (email.isEmpty())
                            Toast.makeText(Forgot.this, "Please Enter E-mail", Toast.LENGTH_SHORT).show();
                        doForgot(email);
                    }
                });
    }

    private void doForgot(String email) {
        Util.showProgress(this);
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Util.hideProgress();
                            Toast.makeText(Forgot.this, "Check Reset Link In Your E-mail", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Util.hideProgress();
                Toast.makeText(Forgot.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
