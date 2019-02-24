package com.example.poopwithme;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class FirebaseUtils {

    public interface OnDatabaseFetchDone {
        void updateMap(ArrayList<BathroomLocation> l);
        void updateBathrooms(ArrayList<BathroomLocation> l);
    }

    private OnDatabaseFetchDone mOnDatabaseFetchDone;


    public static class BathroomLocation implements Serializable {
        public double longitude;
        public double latitude;
        public double avg_review;
        public int num_reviews;
    }

    public static class Bathrooms implements Serializable {
        ArrayList<BathroomLocation> Bathrooms;
    }

    public FirebaseUtils(OnDatabaseFetchDone onDatabaseFetchDone) {
        mOnDatabaseFetchDone = onDatabaseFetchDone;
    }

    public ArrayList<BathroomLocation> bathrooms;

    public void change () {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Bathrooms list = dataSnapshot.getValue(Bathrooms.class);
                Log.d("latLong ", " "+ list.Bathrooms.get(1).avg_review);
                mOnDatabaseFetchDone.updateBathrooms(list.Bathrooms);
                mOnDatabaseFetchDone.updateMap(list.Bathrooms);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });

    }
    public static void addReview (final float review) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                BathroomLocation test = dataSnapshot.child("Bathrooms").child("53").getValue(BathroomLocation.class);

                Log.d("test", " "+ test.avg_review);

                int newScore = (int)((test.avg_review * test.num_reviews + review))/ (test.num_reviews + 1);
                myRef.child("Bathrooms").child("53").child("avg_review").setValue(newScore);
                myRef.child("Bathrooms").child("53").child("num_reviews").setValue(test.num_reviews+1);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });

    }
}
