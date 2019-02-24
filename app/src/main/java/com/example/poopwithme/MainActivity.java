package com.example.poopwithme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.example.poopwithme.FirebaseUtils;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import static com.example.poopwithme.AmenitiesUtils.getLocations;

/* This is the main activity for our app */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback, BathroomAdapter.OnBathroomClickedListener{
    private GoogleMap mMap;
    private MarkerOptions options = new MarkerOptions();

    private RecyclerView mainBathroomRecyclerView;
    private BathroomAdapter mainBathroomAdapter;
    private FirebaseUtils firebaseUtils;
    private ArrayList<LatLng> latlngs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseUtils = new FirebaseUtils();
        FirebaseApp.initializeApp(this);
        firebaseUtils.change();

        mainBathroomRecyclerView = findViewById(R.id.bathroom_rv);
        mainBathroomAdapter = new BathroomAdapter(this, firebaseUtils.bathrooms);

        mainBathroomRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBathroomRecyclerView.setHasFixedSize(true);
        mainBathroomRecyclerView.setAdapter(mainBathroomAdapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onBathroomReviewClicked(FirebaseUtils.BathroomLocation temp) {
        Intent bathroomReviewActivityIntent = new Intent(this, BathroomReviewActivity.class);
        startActivity(bathroomReviewActivityIntent);
    }

    @Override
    public void onBathroomDirectionClicked(double lattitude, double longitude) {
        Uri IntentUri = Uri.parse("geo:" + Double.toString(lattitude) + "," + Double.toString(longitude));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, IntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
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
