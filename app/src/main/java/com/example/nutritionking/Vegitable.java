package com.example.nutritionking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Vegitable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegitable);
        //ArrayList for displaying name,quantity ,price and images
    ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("BEET","1kg","Rs.20/kg", R.drawable.beet));
        words.add(new Word("CUCUMBER","1kg","Rs.40/kg", R.drawable.cucumber));
        words.add(new Word("GINGER","1kg","Rs.40/kg", R.drawable.ginger));
        words.add(new Word("POTATO","1kg","Rs.60/kg", R.drawable.potato2));
        words.add(new Word("CABBAGE","1kg","Rs.30/kg",R.drawable.cabbage));
        words.add(new Word("CAULIFLOWER","1kg","Rs.40/kg",R.drawable.cauliflower));
        words.add(new Word("BEAN","1kg","Rs.50/kg",R.drawable.bean));
        words.add(new Word("CARROT","1kg","Rs.70/kg",R.drawable.carrot));
      //For attaching vegitableAdapter
        VegitableAdapter adapter=
            new VegitableAdapter(this, words);
    ListView listView=(ListView)findViewById(R.id.vegi);
        listView.setAdapter(adapter); //settingAdapter
}}
