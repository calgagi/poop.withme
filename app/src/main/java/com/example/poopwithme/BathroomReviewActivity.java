package com.example.poopwithme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.Timer;
import java.util.TimerTask;

public class BathroomReviewActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_review);
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);

        LinearLayout linearLayout = new LinearLayout(this);
        final RatingBar rating = new RatingBar(this);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        rating.setLayoutParams(lp);
        rating.setNumStars(5);
        rating.setStepSize(1);

        //add ratingBar to linearLayout
        linearLayout.addView(rating);

        popDialog.setTitle("Add Rating: ");

        //add linearLayout to dailog
        popDialog.setView(linearLayout);



        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                System.out.println("Rated val:"+v);
            }
        });



        // Button OK
        popDialog.setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        int timeout = 4000; // make the activity visible for 4 seconds
//
//                        Timer timer = new Timer();
//                        timer.schedule(new TimerTask() {
//
//                            @Override
//                            public void run() {
//                                finish();
//                                Intent homepage = new Intent(BathroomReviewActivity.this, MainActivity.class);
//                                startActivity(homepage);
//                            }
//                        }, timeout);
                        Intent intent = new Intent(BathroomReviewActivity.this, MainActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }

                })

                // Button Cancel
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
//                                int timeout = 4000; // make the activity visible for 4 seconds
//
//                                Timer timer = new Timer();
//                                timer.schedule(new TimerTask() {
//
//                                    @Override
//                                    public void run() {
//                                        finish();
//                                        Intent homepage = new Intent(BathroomReviewActivity.this, MainActivity.class);
//                                        startActivity(homepage);
//                                    }
//                                }, timeout);
                                Intent intent = new Intent(BathroomReviewActivity.this, MainActivity.class);
                                startActivity(intent);
                                dialog.cancel();
                            }
                        });

        popDialog.create();
        popDialog.show();



//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setCancelable(true);
//        builder.setTitle("Rate This Bathroom");
//        builder.setMessage("Message");
//        builder.setPositiveButton("Submit",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
//        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
    }
}