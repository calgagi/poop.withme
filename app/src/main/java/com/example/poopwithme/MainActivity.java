package com.example.poopwithme;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.poopwithme.AmenitiesUtils.getLocations;

/* This is the main activity for our app */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback, BathroomAdapter.OnBathroomClickedListener, FirebaseUtils.OnDatabaseFetchDone {
    private GoogleMap mMap;
    private MarkerOptions options = new MarkerOptions();

    private RecyclerView mainBathroomRecyclerView;
    private BathroomAdapter mainBathroomAdapter;
    private FirebaseUtils firebaseUtils;
    private ArrayList<LatLng> latlngs = new ArrayList<>();
    private SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

    public void updateMap(ArrayList<FirebaseUtils.BathroomLocation> l) {
        new GitHubSearchTask(mapFragment).execute(mapFragment);

    }

    public void updateBathrooms(ArrayList<FirebaseUtils.BathroomLocation> l){
        mainBathroomAdapter.updateBathrooms(l);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseUtils = new FirebaseUtils(this);
        FirebaseApp.initializeApp(this);

        mainBathroomRecyclerView = findViewById(R.id.bathroom_rv);
        mainBathroomAdapter = new BathroomAdapter(this);
        mainBathroomRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBathroomRecyclerView.setHasFixedSize(true);
        mainBathroomRecyclerView.setAdapter(mainBathroomAdapter);
        firebaseUtils.change();
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onBathroomReviewClicked(FirebaseUtils.BathroomLocation temp) {
        Intent bathroomReviewActivityIntent = new Intent(this, BathroomReviewActivity.class);
        startActivity(bathroomReviewActivityIntent);
    }

    @Override
    public void onBathroomDirectionClicked(double latitude, double longitude) {
        Uri IntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Double.toString(longitude) + "," + Double.toString(latitude));
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

    class GitHubSearchTask extends AsyncTask< SupportMapFragment, Void, String> {

        private SupportMapFragment mapFragment;

        public GitHubSearchTask(SupportMapFragment fragment) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//            SupportMapFragment mapFragment = (SupportMapFragment)fragment;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(SupportMapFragment... fragment) {
//            SupportMapFragment mapFragment = fragment[0];
            mapFragment.getMapAsync(mapFragment);
            return "";
        }

//        @Override
        protected void onPostExecute(ArrayList<FirebaseUtils.BathroomLocation> l) {
            if(l != null) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (int i = 0; i < l.size(); i++) {
                    if(l.get(i) != null) {
                        System.out.println(l.get(i).latitude + " " + l.get(i).longitude);
                        LatLng bathroom = new LatLng(l.get(i).longitude, l.get(i).latitude);
                        builder.include(bathroom);
                        mMap.addMarker(new MarkerOptions().position(bathroom).title("Bathroom " + i));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(bathroom));
                    }
                }
                CameraUpdate cu = CameraUpdateFactory.zoomTo((float) 12);
                mMap.animateCamera(cu);
            }
        }
    }

}
