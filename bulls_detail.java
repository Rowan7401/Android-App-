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

    private final LinkedList<String> mPlayerListBulls = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulls_detail);

        mPlayerListBulls.add("Lonzo Ball");
        mPlayerListBulls.add("Tony Bradley");
        mPlayerListBulls.add("Troy Brown Jr");
        mPlayerListBulls.add("Alex Caruso");
        mPlayerListBulls.add("Tyler Cook");
        mPlayerListBulls.add("Demar Derozan");
        mPlayerListBulls.add("Ayo Dosunmu");
        mPlayerListBulls.add("Devon Dotson");
        mPlayerListBulls.add("Javonte Green");
        mPlayerListBulls.add("Alize Johnson");
        mPlayerListBulls.add("Derrick Jones Jr");
        mPlayerListBulls.add("Zach Lavine");
        mPlayerListBulls.add("Marko Simonovic");
        mPlayerListBulls.add("Nikola Vucevuc");
        mPlayerListBulls.add("Coby White");
        mPlayerListBulls.add("Patrick Williams");


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter(this, mPlayerListBulls);
        mRecyclerView.setAdapter(mAdapter);
    }


}
