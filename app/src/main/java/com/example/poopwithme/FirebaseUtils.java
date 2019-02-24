package com.example.poopwithme;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FirebaseUtils {

    List<BathroomLocation> dummy_data;

    public FirebaseUtils(){
        dummy_data = new ArrayList<BathroomLocation>();
        BathroomLocation temp = new BathroomLocation();
        temp.longitude = -34;
        temp.lattitude = 150;
        temp.avg_review = 2.5;
        temp.num_reviews = 2;
        dummy_data.add(temp);
        BathroomLocation temp2 = new BathroomLocation();
        temp2.longitude = -33;
        temp2.lattitude = 151;
        temp2.avg_review = 3.0;
        temp2.num_reviews = 2;
        dummy_data.add(temp2);
    }

    public static class BathroomLocation implements Serializable {
        public double longitude;
        public double lattitude;
        public double avg_review;
        public int num_reviews;
    }
}
