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

public class bulls_stats extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlayerListAdapter mAdapter;

    private final LinkedList<String> mBullStats = new LinkedList<>();
    private final Hashtable<String, int> BullPlayerIDS = new Hashtable<String, int>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulls_stats);
        Intent intent = getIntent();

        BullPlayerIDS.put("Ball", 27);
        BullPlayerIDS.put("Bradley", 60);
        BullPlayerIDS.put("Brown", 68);
        BullPlayerIDS.put("Caruso", 89);
        BullPlayerIDS.put("Cook", 666517);
        BullPlayerIDS.put("Derozan", 125);
        BullPlayerIDS.put("Dosunmu", 17895983);
        BullPlayerIDS.put("Dotson", 3547197);
        BullPlayerIDS.put("Green", 666604);
        BullPlayerIDS.put("Johnson", 240);
        BullPlayerIDS.put("Jones", 247);
        BullPlayerIDS.put("Lavine", 268);
        BullPlayerIDS.put("Simonovic", 4197388);
        BullPlayerIDS.put("Vucevic", 460);
        BullPlayerIDS.put("White", 666956);
        BullPlayerIDS.put("Williams", 3547248);


        mBullStats.add("10/15 3pt");
        mBullStats.add("10/15 3pt");
        mBullStats.add("10/15 3pt");
        mBullStats.add("10/15 3pt");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter(this, mBullStats);
        mRecyclerView.setAdapter(mAdapter);

    }
}*/
