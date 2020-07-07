package com.example.nutritionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterPage extends AppCompatActivity {
    Button Register;
    EditText fName;
    EditText pass;
    EditText cPass;
    EditText contact;
    EditText emailId;
    EditText lName;
    User user;
//onCreate method & link java class with activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_register_page);
       Register=findViewById(R.id.register);
    fName=findViewById(R.id.fn);
    lName=findViewById(R.id.ln);
    pass=findViewById(R.id.password);
    cPass=findViewById(R.id.cpassword);
    contact=findViewById(R.id.contact);
    emailId=findViewById(R.id.email);
        Register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(validate())
                doRegister();

        }
    });

}
    private void doRegister() {
        Util.showProgress(this);
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            savetoDataBase(task.getResult().getUser());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Util.hideProgress();

                Toast.makeText(RegisterPage.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void savetoDataBase(FirebaseUser user) {
        FirebaseFirestore.getInstance().collection("users")
                .document(user.getUid()).set(this.user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(RegisterPage.this, "User Registration Successful", Toast.LENGTH_LONG).show();
                            Util.hideProgress();

                            Intent intent=new Intent(RegisterPage.this, Login.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Util.hideProgress();

                Toast.makeText(RegisterPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean validate(){

        String firstName = fName.getText().toString();
        String lastName = lName.getText().toString();
        String cont = contact.getText().toString();
        String email = emailId.getText().toString();
        String password = pass.getText().toString();
        String cPassword = cPass.getText().toString();
        if(firstName.isEmpty() || lastName.isEmpty()
                || cont.isEmpty() ||email.isEmpty() || password.isEmpty()||cPassword.isEmpty()
        ) {
            Toast.makeText(this, "enter All the field", Toast.LENGTH_SHORT).show();

            return false;
        }
        else if (!password.equals(cPassword)) {
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            user=new User();
            user.setFirstName(firstName);
            user.setEmail(email);
            user.setLastName(lastName);
            user.setNumber(cont);
            user.setPassword(password);
            return true;
        }
    }

}

