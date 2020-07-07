package com.example.nutritionking.ui.rateUs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.nutritionking.R;

public class RateUsFragment extends Fragment {

    private RatingBar ratingBar;

    private TextView tvRateCount,tvRateMessage;

    private float ratedValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rateus,
                container, false);


        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        tvRateCount = (TextView) view.findViewById(R.id.tvRateCount);

        tvRateMessage = (TextView) view.findViewById(R.id.tvRateMessage);



        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override

            public void onRatingChanged(RatingBar ratingBar, float rating,

                                        boolean fromUser) {

                ratedValue = ratingBar.getRating();

                tvRateCount.setText("Your Rating : "

                        + ratedValue + "/5.");

                if (ratedValue < 1) {

                    tvRateMessage.setText("ohh ho...");

                } else if (ratedValue < 2) {

                    tvRateMessage.setText("Ok.");

                } else if (ratedValue < 3) {

                    tvRateMessage.setText("Not bad.");

                } else if (ratedValue < 4) {

                    tvRateMessage.setText("Nice");

                } else if (ratedValue < 5) {

                    tvRateMessage.setText("Very Nice");

                } else if (ratedValue == 5) {

                    tvRateMessage.setText("Thank you..!!!");


                }

            }

        });
        return view;
    }}