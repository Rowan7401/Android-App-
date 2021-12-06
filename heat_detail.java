package com.example.nbastatsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbastatsapp.R;

import java.util.LinkedList;

public class heat_detail extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlayerListAdapter2 mAdapter;

    private final LinkedList<String> mPlayerListHeat = new LinkedList<>();
    private final LinkedList<String> mHeatStats = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heat_detail);

        mPlayerListHeat.add("Bam Adebayo");
        mPlayerListHeat.add("Jimmy Butler");
        mPlayerListHeat.add("Dewayne Dedmond");
        mPlayerListHeat.add("Marcus Garrett");
        mPlayerListHeat.add("Udonis Haslem");
        mPlayerListHeat.add("Tyler Herro");
        mPlayerListHeat.add("Kyle Lowry");
        mPlayerListHeat.add("Caleb Martin");
        mPlayerListHeat.add("Markief Morris");
        mPlayerListHeat.add("KZ Opala");
        mPlayerListHeat.add("Victor Oladipo");
        mPlayerListHeat.add("Max Straus");
        mPlayerListHeat.add("PJ Tucker");
        mPlayerListHeat.add("Gabe Vincent");
        mPlayerListHeat.add("Omer Yurtseven");

        mHeatStats.add("10/15 3pt");
        mHeatStats.add("10/15 3pt");
        mHeatStats.add("10/15 3pt");
        mHeatStats.add("10/15 3pt");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter2(this, mPlayerListHeat, mHeatStats);
        mRecyclerView.setAdapter(mAdapter);
    }


}