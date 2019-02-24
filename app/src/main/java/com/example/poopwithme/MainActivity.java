package com.example.poopwithme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.poopwithme.AmenitiesUtils.getLocations;

/* This is the main activity for our app */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback, BathroomAdapter.OnBathroomClickedListener{
    private GoogleMap mMap;

    private RecyclerView mainBathroomRecyclerView;
    private BathroomAdapter mainBathroomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBathroomRecyclerView = findViewById(R.id.bathroom_rv);
        mainBathroomAdapter = new BathroomAdapter(this);

        mainBathroomRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBathroomRecyclerView.setHasFixedSize(true);
        mainBathroomRecyclerView.setAdapter(mainBathroomAdapter);
    }

    @Override
    public void onBathroomReviewClicked(String position) {
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

    }
}
