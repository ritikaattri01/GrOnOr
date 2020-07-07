package com.example.nutritionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    CartAdapter2 cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoodCartList foodCartList;

        String discc=getIntent().getStringExtra("discc");
        foodCartList=new Gson().fromJson(discc,FoodCartList.class);
        cartAdapter = new CartAdapter2(this,foodCartList);
        RecyclerView recyclerView=findViewById(R.id.recycler1);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(cartAdapter);
        findViewById(R.id.order)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Util.showProgress(MainActivity2.this);
                   //     Booking booking = new Booking();
                        //  booking.setUid(FirebaseAuth.getInstance().getUid());
                    //    booking.setTimestemp(new Date().getTime());
                    //    booking.setItems(cartAdapter.foodCartList.getList());

                        //FirebaseFirestore.getInstance().collection("orders")
                              //  .document().set(booking)
                              //  .addOnCompleteListener(new OnCompleteListener<Void>() {
                                //    @Override
                                   // public void onComplete(@NonNull Task<Void> task) {
                                       // if (task.isSuccessful()) {
                                            Toast.makeText(MainActivity2.this, "Order Placed Succesfully", Toast.LENGTH_SHORT).show();
                                          //  Util.hideProgress();
                                            Intent intent = new Intent(MainActivity2.this, NavDrawer.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                            finish();
                                        }
                                    //}
                               // }).addOnFailureListener(new OnFailureListener() {
                          //  @Override
                           // public void onFailure(@NonNull Exception e) {
                            //    Util.hideProgress();
                            //    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                         //   }
                     //   });
                   // }
                });
    }

}
