package com.example.nutritionking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_item_order extends RecyclerView.Adapter<Adapter_item_order.Holder> {
    Context context;
    ArrayList<Cart> items;
    public Adapter_item_order(Context context, ArrayList<Cart> items) {
        this.context=context;
        this.items=items;
    }

    @NonNull
    @Override
    public Adapter_item_order.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item_view,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_item_order.Holder holder, int position) {
        Picasso.with(context)
                .load(items.get(position).getImage())
                .into(holder.imageView);
        holder.name.setText(items.get(position).getName());
        holder.price.setText(items.get(position).getPrice());
      //  holder.quantity.setText(items.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
       // TextView quantity;
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.Image);
            name=itemView.findViewById(R.id.name1);
          //  quantity=itemView.findViewById(R.id.quantiy);
            price=itemView.findViewById(R.id.price1);
        }
    }
}
