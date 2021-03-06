package com.example.nbastatsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbastatsapp.R;

import java.util.LinkedList;

public class bulls_detail extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlayerListAdapter mAdapter;

    private final LinkedList<String> mPlayerList = new LinkedList<>();
    private final LinkedList<String> mBullsStats = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulls_detail);

        mPlayerList.add("Zach Lavine");
        mPlayerList.add("Lonzo Ball");
        mPlayerList.add("Alex Caruso");
        mPlayerList.add("Demar DeRozan");
        mPlayerList.add("Nikola Vucivic");

        mBullsStats.add("10/15 3pt");
        mBullsStats.add("10/15 3pt");
        mBullsStats.add("10/15 3pt");
        mBullsStats.add("10/15 3pt");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter(this, mPlayerList, mBullsStats);
        mRecyclerView.setAdapter(mAdapter);
    }


}
