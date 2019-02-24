package com.example.poopwithme;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.poopwithme.AmenitiesUtils.getLocations;

/* This is the main activity for our app */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private String TAG = MainActivity.class.getSimpleName();
    private GoogleMap mMap;

    private RecyclerView mainBathroomRecyclerView;
    private BathroomAdapter mainBathroomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBathroomRecyclerView = findViewById(R.id.bathroom_rv);

        mainBathroomRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBathroomRecyclerView.setHasFixedSize(true);
        mainBathroomAdapter = new BathroomAdapter();
        mainBathroomRecyclerView.setAdapter(mainBathroomAdapter);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        LatLng[] markers = new LatLng[]();
        // Add a m0arker in bathroom and move the camera
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i= 0; i < 3; i++) {
            LatLng bathroom = new LatLng(getLocations(i)[1], getLocations(i)[0]);
            builder.include(bathroom);
            mMap.addMarker(new MarkerOptions().position(bathroom).title("Bathroom "+i));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(bathroom));
        }

//        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 5,5,0));
//        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(builder.build(), 5,5,0);
        CameraUpdate cu = CameraUpdateFactory.zoomTo((float)12);
        mMap.animateCamera(cu);

    }
}
