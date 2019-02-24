package com.example.poopwithme;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.poopwithme.AmenitiesUtils.getBathrooms;
import static com.example.poopwithme.AmenitiesUtils.getLocations;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getBathrooms();
        getLocations(0);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near bathroom, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
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
