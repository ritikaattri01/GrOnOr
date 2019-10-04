package com.example.nutritionking;

public class Word {
    //Declaration
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private String mPrice;
    private int mImageResource;
    //Constructor
public Word(String miwokTranslation, String defaultTranslation,String price, int imageResource ){
    mMiwokTranslation=miwokTranslation;
    mDefaultTranslation=defaultTranslation;
    mImageResource=imageResource;
    mPrice=price;
}
  //Method
public String getmDefaultTranslation() {
    return mDefaultTranslation;
}
public String getmMiwokTranslation() {
    return mMiwokTranslation;
}
public String getmPrice(){return mPrice;}
public int getmImageResource() {
        return mImageResource;
    }

}