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

public class Adapter1 extends RecyclerView.Adapter<Adapter1.Holder> {
    Context context;
    Data data;
    ArrayList<Cart> list;
    public Adapter1(Context context, Data data) {
        this.context=context;
        this.data=data;
        list=new ArrayList<>();

    }

    @NonNull
    @Override
    public Adapter1.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view,viewGroup,false);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final Adapter1.Holder holder, final int i) {

        Picasso.with(context).load(data.images[i]).placeholder(R.drawable.dummy).into(holder.imageView);
        holder.discount.setText(data.discount[i]);
        holder.name.setText(data.name[i]);
        holder.discountprice.setText(data.price[i]);
        final String price=getPrice(data.price[i],data.discount[i].replace("% Off",""));
        holder.discountprice.setText(price);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart= new Cart();
                cart.setImage(data.images[i]);
                cart.setPrice(data.price[i]);
                cart.setName(data.name[i]);
                cart.setCount(1);

                if (holder.button.getText().equals("ADD")){
                    list.add(cart);
                    holder.button.setText("REMOVE");
                }else
                {
                    Util.showProgress(context);
                    int index=getIndex(cart.getName());
                    if (index>-1) {
                        list.remove(index);
                        holder.button.setText("ADD");
                    }
                    Util.hideProgress();
                }
            }
        });}

    private String getPrice(String price, String discount){
            int pri = Integer.parseInt(price.replace("Rs.", ""));
            int dis = Integer.parseInt(discount);
            int totalPrice = pri ;
            String rs = "Rs." + totalPrice;
            return rs;
        }
   private int getIndex(String s) {
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
        return data.images.length;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView discountprice;
        TextView discount;
        TextView button;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.itemImage);
            name=itemView.findViewById(R.id.name);
            discountprice =itemView.findViewById(R.id.price);
            button=itemView.findViewById(R.id.add);
            discount=itemView.findViewById(R.id.discount);
        }
    }
}
