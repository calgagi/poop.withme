package com.example.poopwithme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/* This class manages the RecyclerView's items. It also binds

 */

public class BathroomAdapter extends RecyclerView.Adapter<BathroomAdapter.BathroomViewHolder> {
    private ArrayList<FirebaseUtils.BathroomLocation> mBathrooms;
    private OnBathroomClickedListener mBathroomClickedListener;


    public interface OnBathroomClickedListener {
        void onBathroomReviewClicked(FirebaseUtils.BathroomLocation temp);
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
        FirebaseUtils.BathroomLocation bathroom = mBathrooms.get(adapterPositionToArrayIndex(position));
        holder.bind(bathroom);
    }

    private int adapterPositionToArrayIndex(int adapterPosition) {
        return mBathrooms.size() - adapterPosition - 1;
    }



    public BathroomAdapter(OnBathroomClickedListener clickedListener, ArrayList<FirebaseUtils.BathroomLocation> list) {
        mBathrooms = list;
        mBathroomClickedListener = clickedListener;
    }

    /* CHANGE THIS TO SUPPORT API REQUEST */
    public void addBathroom(FirebaseUtils.BathroomLocation bathroom) {
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
                    FirebaseUtils.BathroomLocation temp = mBathrooms.get(adapterPositionToArrayIndex(getAdapterPosition()));
                    mBathroomClickedListener.onBathroomReviewClicked(temp);
                }
            });
            directionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseUtils.BathroomLocation temp = mBathrooms.get(adapterPositionToArrayIndex(getAdapterPosition()));
                    mBathroomClickedListener.onBathroomDirectionClicked(temp.latitude, temp.longitude);
                }
            });
        }

        void bind(FirebaseUtils.BathroomLocation bathroomLocation) {
            mBathroomTextView.setText(Double.toString(bathroomLocation.latitude));
        }
    }

}
