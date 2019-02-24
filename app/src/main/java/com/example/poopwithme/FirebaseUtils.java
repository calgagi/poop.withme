package com.example.poopwithme;

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
//    class Bathrooms {
//        public HashMap bathrooms;
//    }
//    class Post {
//        public int starCount;
//        public HashMap reviews;
//    }
//    private void onStarClicked(DatabaseReference postRef) {
//        postRef.runTransaction(new Transaction.Handler() {
//            @Override
//            public Transaction.Result doTransaction(MutableData mutableData) {
//                Post p = mutableData.getValue(Post.class);
//                if (p == null) {
//                    return Transaction.success(mutableData);
//                }
//
////                if (p.reviews.containsKey(getUid())) {
////                    // Unstar the post and remove self from stars
////                    p.starCount = p.starCount - 1;
////                    p.reviews.remove(getUid());
////                } else {
//                    // Star the post and add self to stars
//                p.starCount = p.starCount + 1;
//                p.reviews.put(getUid(), true);
////                }
//
//                // Set value and report transaction success
//                mutableData.setValue(p);
//                return Transaction.success(mutableData);
//            }
//
//            private Object getUid() {
//                final Object uid = "test";
//                return uid;
//            }
//
//            @Override
//            public void onComplete(DatabaseError databaseError, boolean b,
//                                   DataSnapshot dataSnapshot) {
//                // Transaction completed
//                Log.d(TAG, "postTransaction:onComplete:" + databaseError);
//            }
//        });
//    }
    public static class BathroomLocation implements Serializable {
        public double longitude;
        public double latitude;
        public double avg_review;
        public int num_reviews;
    }
    public static class Bathrooms implements Serializable {
        ArrayList<BathroomLocation> Bathrooms;
//        public BathroomLocation[] Bathrooms;
    }
    public static void change () {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        mDatabase.child("users").child(userId).child("username").setValue(name);
        DatabaseReference myRef = database.getReference("");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Bathrooms list = dataSnapshot.getValue(Bathrooms.class);
//                Log.d("latLong ", " "+ list.Bathrooms.get("1"));
                Log.d("latLong ", " "+ list.Bathrooms.get(1).avg_review);
                // ...
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
