package com.example.nbastatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbastatsapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class heat_detail extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PlayerListAdapter2 mAdapter;

    private EditText mPlayerID;
    private TextView mPPG;
    private TextView mShootingPercentage;
    private TextView mRebounds;
    private TextView mAssists;

    private final LinkedList<String> mPlayerListHeat = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heat_detail);

        mPlayerID = (EditText) findViewById(R.id.playerIDInput);
        mPPG = (TextView) findViewById(R.id.ppg);
        mRebounds = (TextView) findViewById(R.id.reb);
        mAssists = (TextView) findViewById(R.id.ast);
        mShootingPercentage = (TextView) findViewById(R.id.sp);

        mPlayerListHeat.add("Bam Adebayo (Player ID :4)");
        mPlayerListHeat.add("Jimmy Butler (Player ID :79)");
        mPlayerListHeat.add("Dewayne Dedmond (Player ID :120)");
        mPlayerListHeat.add("Marcus Garrett (Player ID :17553997)");
        mPlayerListHeat.add("Udonis Haslem (Player ID :203)");
        mPlayerListHeat.add("Tyler Herro (Player ID :666633)");
        mPlayerListHeat.add("Kyle Lowry (Player ID :286)");
        mPlayerListHeat.add("Caleb Martin (Player ID :666747)");
        mPlayerListHeat.add("Markief Morris (Player ID :329)");
        mPlayerListHeat.add("KZ Opala (Player ID :666821)");
        mPlayerListHeat.add("Victor Oladipo (Player ID :357)");
        mPlayerListHeat.add("Max Straus (Player ID :666908)");
        mPlayerListHeat.add("PJ Tucker (Player ID :350)");
        mPlayerListHeat.add("Gabe Vincent (Player ID :1603383)");
        mPlayerListHeat.add("Omer Yurtseven (Player ID :11891374)");


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PlayerListAdapter2(this, mPlayerListHeat);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void searchStats(View view) {
        String queryString = mPlayerID.getText().toString();
        FetchStats fs = new FetchStats(mPPG, mShootingPercentage, mRebounds, mAssists);
        fs.execute(queryString);
    }



}