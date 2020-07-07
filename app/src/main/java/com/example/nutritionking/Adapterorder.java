package com.example.nutritionking;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Adapterorder extends RecyclerView.Adapter<Adapterorder.Holder> {
    ArrayList<Booking> bookings;
    Context context;
    Adapterorder(Context context)
    {
        this.context=context;
        bookings=new ArrayList<>();
    }
    @NonNull
    @Override
    public Adapterorder.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_view,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterorder.Holder holder, int position) {
        holder.date.setText(getDate(bookings.get(position).getTimestemp()));
        Adapter_item_order adapterorder=new Adapter_item_order(context,bookings.get(position).getItems());
        RecyclerView.LayoutManager manager=new LinearLayoutManager(context,RecyclerView.VERTICAL,false);
        holder.items.setLayoutManager(manager);
        holder.items.setAdapter(adapterorder);
        holder.tt.setText(totalPrice(bookings.get(position)));

    }

    private String totalPrice(Booking booking) {
        int price=0;
        for (Cart cart:booking.getItems())
        {
            int p= Integer.parseInt(cart.getPrice().replace("Rs.",""));
            price=price+p;

        }
        String price1="Total: Rs." + price;
        return price1+"";
    }

    private String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }
    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public void add(Booking booking) {
        this.bookings.add(booking);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView date;
        TextView tt;
        RecyclerView items;

        public Holder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            items=itemView.findViewById(R.id.itemRecyerView);
            tt=itemView.findViewById(R.id.tt);
        }
    }
}
