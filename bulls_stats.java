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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulls_stats);
        Intent intent = getIntent();

        mBullStats.add("10/15 3pt");
        mBullStats.add("10/15 3pt");
        mBullStats.add("10/15 3pt");
        mBullStats.add("10/15 3pt");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter(this, mBullStats);
        mRecyclerView.setAdapter(mAdapter);

    }
}
