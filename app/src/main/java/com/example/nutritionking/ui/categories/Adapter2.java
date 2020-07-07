package com.example.nutritionking.ui.categories;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritionking.FoodItems;
import com.example.nutritionking.Homepage;
import com.example.nutritionking.R;
import com.squareup.picasso.Picasso;


public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyHolder> {
    CategoryData categoryData;
    FragmentActivity context;
    String shopName;
    String list;
    public Adapter2(FragmentActivity activity) {
        categoryData=new CategoryData();
      this.context=activity;

    }

    @NonNull
    @Override
    public Adapter2.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_view,viewGroup,false);
        return new MyHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.name.setText(categoryData.names[i]);
        Picasso.with(context).load(categoryData.images[i]).placeholder(R.drawable.dummy).into(myHolder.image);

        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FoodItems.class);
                intent.putExtra("type",categoryData.names[i]);
                intent.putExtra("list",list);
                intent.putExtra("shopName",shopName);
                intent.putExtra("image",shopName);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return categoryData.images.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        CardView cardView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.namee);
            image=itemView.findViewById(R.id.img);
            cardView=itemView.findViewById(R.id.cartt);
        }
    }
}
