package com.example.poopwithme;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/* This is the main activity for our app */
public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

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

}
