package com.example.nutritionking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fruits extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        //ArrayList for displaying name,quantity ,price and images

        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("APPLE","1pc","Rs.20/kg", R.drawable.apple));
        words.add(new Word("BANANA","1kg","Rs.60/kg", R.drawable.banana));
        words.add(new Word("GRAPE","1kg","Rs.20/kg", R.drawable.grape));
        words.add(new Word("GREENAPPLE","1pc","Rs.30/kg", R.drawable.greenapple));
        words.add(new Word("PINEAPPLE","1pc","Rs.30/kg",R.drawable.pineapple));
        words.add(new Word("BLACKGRAPES","1kg","Rs.90/kg",R.drawable.blackgrapes));
        words.add(new Word("MANGO","1kg","Rs.80/kg",R.drawable.mango));
        words.add(new Word("LICHI","1kg","Rs.70/kg",R.drawable.lichi));
        words.add(new Word("STRAWBERRIES","1kg","Rs.80/kg",R.drawable.strawberries));


        //For attaching fruitAdapter

        FruitAdapter adapter=
                new FruitAdapter(this, words);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);//settingAdapter
    }}

