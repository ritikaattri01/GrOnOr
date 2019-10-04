package com.example.nutritionking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Beverages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);
        //ArrayList using Word Class
        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("PEPSI","2ml","Rs.20", R.drawable.cold1));
        words.add(new Word("COKE","2ml","Rs.30", R.drawable.cold2));
        words.add(new Word("one","2ml","Rs.20", R.drawable.cold3));
        words.add(new Word("SPRITE","2ml","Rs.30", R.drawable.cold4));
        words.add(new Word("COKE","2ml","Rs.30",R.drawable.cold5));
        words.add(new Word("REAL","2ml","Rs.90",R.drawable.cold6));
        words.add(new Word("REAL","2ml","Rs.80",R.drawable.cold7));
        words.add(new Word("ALOVERA","2ml","Rs.70",R.drawable.cold8));
        words.add(new Word("MAAZA","2ml","Rs.40",R.drawable.cold9));
        words.add(new Word("TROPICANA","2ml","Rs.80",R.drawable.cold0));

        WordAdapter adapter=
                new WordAdapter(this, words);
    ListView listView=(ListView)findViewById(R.id.list);
    listView.setAdapter(adapter);
}}
