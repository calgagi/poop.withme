package com.example.poopwithme;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

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
    public static class BathroomLocation implements Serializable {
        public double longitude;
        public double latitude;
        public double avg_review;
        public int num_reviews;
    }

    public static class Bathrooms implements Serializable {
        ArrayList<BathroomLocation> Bathrooms;
    }

    public FirebaseUtils(){
        bathrooms = new ArrayList<BathroomLocation>();
        BathroomLocation temp = new BathroomLocation();
        temp.latitude = 100;
        temp.longitude = 50;
        temp.num_reviews = 2;
        temp.avg_review = 3;
        bathrooms.add(temp);
    }

    public ArrayList<BathroomLocation> bathrooms;

    public void change () {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Bathrooms list = dataSnapshot.getValue(Bathrooms.class);
                Log.d("latLong ", " "+ list.Bathrooms.get(1).avg_review);
                bathrooms = list.Bathrooms;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };

        myRef.addListenerForSingleValueEvent(postListener);
    }

}
