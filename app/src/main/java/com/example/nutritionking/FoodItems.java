package com.example.nutritionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class FoodItems extends AppCompatActivity {
RecyclerView recyclerView;
    FoodAdapter foodAdapter;
   FloatingActionButton cart2;

    //   String shopName;
 //   String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items);
        cart2=findViewById(R.id.btn2);

        String name=getIntent().getStringExtra("type");
        recyclerView=findViewById(R.id.itemrecycler);
        RecyclerView.LayoutManager manager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);

        foodAdapter = new FoodAdapter(this);

        cart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodCart> list=foodAdapter.list;
                if (list.isEmpty())
                    Toast.makeText(FoodItems.this, "Please select One Time", Toast.LENGTH_SHORT).show();
                else {
                    FoodCartList foodCartList = new FoodCartList();
                    foodCartList.setList(list);
                    String discc=new Gson().toJson(foodCartList);
                    Intent intent = new Intent(FoodItems.this, MainActivity2.class);
                    intent.putExtra("discc",discc);
                    startActivity(intent);


                }
            }
        });
        setData(name);
    }

    private void setData(String name) {
        ImageList imageList=new ImageList();
        NameList nameList=new NameList();
        CostList costList=new CostList();
        switch (name)
        {

            case "Detergent Powder and Liquids":
            {

                Product product=new Product();
                product.setImages(imageList.DetergentImage);
                product.setNames(nameList.DetergentName);
                product.setCost(costList.DetergentCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Atta, Flour & Rice":
            {

                Product product=new Product();
                product.setImages( imageList.AttaImage);
                product.setNames( nameList.AttaName);
                product.setCost(costList.AttaCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }

            case "Fruits & Vegetables":
            {
                Product product=new Product();
                product.setImages( imageList.FruitsImage);
                product.setNames( nameList.FruitsName);
                product.setCost(costList.FruitsCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;

            }
            case  "Dal & Pulses":
            {

                Product product=new Product();
                product.setImages( imageList.DalImage);
                product.setNames( nameList.DalName);
                product.setCost(costList.DalCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Cooking Oils":
            {
                Product product=new Product();
                product.setImages( imageList.CookingOilImage);
                product.setNames( nameList.CookingOilName);
                product.setCost(costList.CookingOilCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Snacks,Juice & Cold Drinks":
            {
                Product product=new Product();
                product.setImages( imageList.SnacksImage);
                product.setNames( nameList.SnacksName);
                product.setCost(costList.SnacksCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Masalas,Spices & Cooking Pastes":
            {
                Product product=new Product();
                product.setImages( imageList.MasalaImage);
                product.setNames( nameList.MasalaName);
                product.setCost(costList.MasalaCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Biscuits & Cookies":
            {
                Product product=new Product();
                product.setImages( imageList.BiscuitsImage);
                product.setNames( nameList.BiscuitName);
                product.setCost(costList.BiscuitCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Home Cleaners":
            {
                Product product=new Product();
                product.setImages( imageList.HomeCleanersImage);
                product.setNames( nameList.HomeCleanerName);
                product.setCost(costList.HomeCleanerCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }
            case "Soap,Handwash & more":
            {
                Product product=new Product();
                product.setImages( imageList.SoapsImage);
                product.setNames( nameList.SoapsName);
                product.setCost(costList.SoapsCost);
                foodAdapter.data(product);
                recyclerView.setAdapter(foodAdapter);
                break;
            }


        }
    }
}
