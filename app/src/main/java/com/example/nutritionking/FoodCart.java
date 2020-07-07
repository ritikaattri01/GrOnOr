package com.example.nutritionking;

public class FoodCart{


    String order_number;
    String name;
    String note;
    String price;
    int count;

    public String getOrder_number() {
        return order_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public FoodCart(String name, String note, String price, int count) {
       // this.order_number = order_number;
        this.name = name;
        this.note = note;
        this.price = price;
        this.count = count;
    }
    public FoodCart() {
    }


}


