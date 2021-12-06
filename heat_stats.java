/*
package com.example.nbastatsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbastatsapp.R;

import java.util.LinkedList;

public class heat_stats extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlayerListAdapter mAdapter;

    private final LinkedList<String> HeatStats = new LinkedList<>();
    private final Hashtable<String, int> HeatPlayerIDS = new Hashtable<String, int>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heats_stats);
        Intent intent = getIntent();

        HeatPlayerIDS.put("Adebayo", 4);
        HeatPlayerIDS.put("Butler", 79);
        HeatPlayerIDS.put("Dedmond", 120);
        HeatPlayerIDS.put("Garrett", 17553997);
        HeatPlayerIDS.put("Haslem", 203);
        HeatPlayerIDS.put("Herro", 666633);
        HeatPlayerIDS.put("Lowry", 286);
        HeatPlayerIDS.put("Martin", 666747);
        HeatPlayerIDS.put("Morris", 329);
        HeatPlayerIDS.put("Opala", 666821);
        HeatPlayerIDS.put("Oladipo", 357);
        HeatPlayerIDS.put("Straus", 666908);
        HeatPlayerIDS.put("Tucker", 450);
        HeatPlayerIDS.put("Vincent", 1603383);
        HeatPlayerIDS.put("Yurtseven", 11891374);



        mHeatStats.add("10/15 3pt");
        mHeatStats.add("10/15 3pt");
        mHeatStats.add("10/15 3pt");
        mHeatStats.add("10/15 3pt");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter(this, mHeatStats);
        mRecyclerView.setAdapter(mAdapter);

    }
}*/
