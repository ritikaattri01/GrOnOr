package com.example.nutritionking;

import android.app.ProgressDialog;
import android.content.Context;

public class Util {
    static ProgressDialog progressDialog;
    public static void showProgress(Context context)
    {


                initProgress(context);




    }

    private static void initProgress(Context context) {
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("wait a sec...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }
    public static void hideProgress()
    {
        if (progressDialog!=null)
            progressDialog.dismiss();
    }
}
