package com.example.poopwithme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/* This class manages the RecyclerView's items. It also binds

 */

public class BathroomAdapter extends RecyclerView.Adapter<BathroomAdapter.BathroomViewHolder> {
    private ArrayList<String> mBathrooms;
    private OnBathroomClickedListener mBathroomClickedListener;


    public interface OnBathroomClickedListener {
        void onBathroomReviewClicked(String pos);
        void onBathroomDirectionClicked(double lattitude, double longitude);
    }

    @Override
    public BathroomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.bathroom_item, viewGroup, false);
        BathroomViewHolder viewHolder = new BathroomViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(BathroomViewHolder holder, int position) {
        String bathroom = mBathrooms.get(adapterPositionToArrayIndex(position));
        holder.bind(bathroom);
    }

    private int adapterPositionToArrayIndex(int adapterPosition) {
        return mBathrooms.size() - adapterPosition - 1;
    }




    public BathroomAdapter(OnBathroomClickedListener clickedListener) {
        mBathrooms = new ArrayList<String>();
        for(int i = 0; i < 20; i++){
            mBathrooms.add(Integer.toString(i));
        }
        mBathroomClickedListener = clickedListener;
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



    public class BathroomViewHolder extends RecyclerView.ViewHolder {
        private TextView mBathroomTextView;
        private Button reviewButton;
        private Button directionButton;


        public BathroomViewHolder(View itemView) {
            super(itemView);
            mBathroomTextView = itemView.findViewById(R.id.bathroom_textview);
            reviewButton = itemView.findViewById(R.id.bathroom_review_button);
            directionButton = itemView.findViewById(R.id.bathroom_dir_button);
            reviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = mBathrooms.get(adapterPositionToArrayIndex(getAdapterPosition()));
                    mBathroomClickedListener.onBathroomReviewClicked(text);
                }
            });
            directionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = mBathrooms.get(adapterPositionToArrayIndex(getAdapterPosition()));
                    mBathroomClickedListener.onBathroomDirectionClicked(44.564568, -123.262047);
                }
            });
        }

        void bind(String text) {
            mBathroomTextView.setText(text);
        }
    }

}
