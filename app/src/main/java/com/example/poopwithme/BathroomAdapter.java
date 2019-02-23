package com.example.poopwithme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/* This class manages the RecyclerView's items. It also binds

 */

public class BathroomAdapter extends RecyclerView.Adapter<BathroomViewHolder> {
    private ArrayList<String> mBathrooms;

    @Override
    public BathroomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.bathroom_item, viewGroup, false);
        BathroomViewHolder viewHolder = new BathroomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BathroomViewHolder holder, int position) {
        String todo = mBathrooms.get(mBathrooms.size() - position - 1);
        holder.bind(todo);
    }

    public BathroomAdapter() {
        mBathrooms = new ArrayList<String>();
        mBathrooms.add("hi");
        mBathrooms.add("hi2");
    }

    /* CHANGE THIS TO SUPPORT API REQUEST */
    public void addBathroom(String bathroom) {
        mBathrooms.add(bathroom);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mBathrooms.size();
    }

}
