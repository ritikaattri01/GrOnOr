package com.example.nutritionking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Beverages beverages, ArrayList< Word > words) {
        super(beverages,0, words);
    }
    //For main layout i.e list_item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //Assigning id's ,set&get methods
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
