package com.example.nutritionking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.Holder>  {
    Product food;
    Context context;
    ArrayList<FoodCart> list;

    public FoodAdapter(Context context) {
        this.context=context;
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview,parent,false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        holder.itemName.setText(food.getNames()[i]);
        // holder.itemCategory.setText(product.getCategory()[i]);
        holder.itemCost.setText("Rs." + food.getCost()[i]);
        Picasso.with(context).load(food.images[i]).placeholder(R.drawable.dummy).into(holder.itemImage);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.add.getText().equals("ADD")) {
                    FoodCart foodCart = new FoodCart(food.getNames()[i],
                            food.getNames()[i]+"and"+ food.getCost()[i],
                            food.cost[i],
                            1);
                    list.add(foodCart);
                    Toast.makeText(context,"Added to Cart", Toast.LENGTH_SHORT).show();
                    holder.add.setText("REMOVE");
                }else
                {
                    int index= removeItem(food.getNames()[i]+"and"+ food.getCost()[i]);

                    list.remove(index);
                    holder.add.setText("ADD");

                }
            }
        });
    }

    private int removeItem(String s) {
        for (int i=0; i<list.size();i++)
        {
            if (s.equals(list.get(i).name));
            {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return food.images.length;
    }

    public void data(Product food) {
        this.food=food;
    }



    public class Holder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemImage;
     //   TextView itemCategory;
        TextView itemCost;
        TextView add;
        public Holder(@NonNull View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.itemName);
            itemImage=itemView.findViewById(R.id.itemImage);
           // itemCategory=itemView.findViewById(R.id.itemCategory);
            itemCost=itemView.findViewById(R.id.itemPrice);
            add=itemView.findViewById(R.id.itemAdd);

        }
    }}
//    interface openCart
//    {
//        void openCart();
//    }
//}

