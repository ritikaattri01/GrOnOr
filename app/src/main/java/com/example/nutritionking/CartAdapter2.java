package com.example.nutritionking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter2 extends RecyclerView.Adapter<CartAdapter2.Holder> {
    Context context;
        FoodCartList foodCartList;

        public CartAdapter2(Context context , FoodCartList foodCartList)  {
            this.context=context;
            this.foodCartList=foodCartList;
        }


    @NonNull
        @Override
        public CartAdapter2.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.cart,viewGroup,false);
            return new CartAdapter2.Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final CartAdapter2.Holder holder, final int position) {
            final FoodCart cart = foodCartList.list.get(position);
            holder.name.setText(cart.getName());
            holder.count.setText(cart.getCount() + "");
            holder.price.setText(cart.getPrice());
            // holder.quantity.setText(cart.getQuantity()+"");

            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = cart.getCount();
                    int actualCount = count + 1;
                    foodCartList.getList().get(position).setCount(actualCount);
                    holder.count.setText(actualCount + "");
                }
            });
            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = cart.getCount();
                    if (count > 1) {
                        int actualCount = count - 1;
                        foodCartList.getList().get(position).setCount(actualCount);
                        holder.count.setText(actualCount + "");

                    }
                }
            });
        }



        @Override
        public int getItemCount() {
            return foodCartList.list.size();
        }

        public class Holder extends RecyclerView.ViewHolder {
            TextView name;
            TextView count;
            TextView price;
            TextView plus;
            TextView minus;
            // TextView quantity;
            public Holder(@NonNull View itemView) {
                super(itemView);
                name=itemView.findViewById(R.id.fvname);
                count=itemView.findViewById(R.id.no);
                price=itemView.findViewById(R.id.rs);
                plus=itemView.findViewById(R.id.plus);
                minus=itemView.findViewById(R.id.minus);
                // quantity=itemView.findViewById(R.id.quantiy);
            }
        }




    }

