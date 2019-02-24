package com.example.poopwithme;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/* This class binds a RecyclerView item to an item from the ArrayList in .
 */


public class BathroomViewHolder extends RecyclerView.ViewHolder {
    private TextView mBathroomViewHolder;



    public BathroomViewHolder(View itemView) {
        super(itemView);
        mBathroomViewHolder = itemView.findViewById(R.id.bathroom_textview);
    }

    void bind(String text) {
        mBathroomViewHolder.setText(text);
    }
}
