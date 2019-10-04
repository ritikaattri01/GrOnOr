package com.example.nutritionking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FruitAdapter extends ArrayAdapter<Word> {

    //Setting parameters
    public FruitAdapter(Fruits fruits, ArrayList< Word > words) {
        super(fruits,0, words);
    }
    //get main method i.e list_item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //get&st methods and id's
        Word currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentWord.getmMiwokTranslation());



        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price);
        priceTextView.setText(currentWord.getmPrice());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.itemimage);
        iconView.setImageResource(currentWord.getmImageResource());

        return listItemView;
    }
}
