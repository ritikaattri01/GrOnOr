package com.example.nutritionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    Adapter1 adapter;
    FloatingActionButton cart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler);
        Data data=new Data();
        cart=view.findViewById(R.id.butn1);

        adapter = new Adapter1(getActivity(),data);
        RecyclerView.LayoutManager manager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Cart> list=adapter.list;
                if (list.isEmpty())
                    Toast.makeText(getContext(), "Please select One Time", Toast.LENGTH_SHORT).show();
                else {
                    CartList cartList = new CartList();
                    cartList.setList(list);
                    String disc=new Gson().toJson(cartList);
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("disc",disc);
                    startActivity(intent);


                }
           }

        });

    }

}