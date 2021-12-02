package com.example.nbastatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TeamListAdapter mAdapter;

    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;
    private final LinkedList<String> mTeamList = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTeamRecord = (EditText) findViewById(R.id."teamRecord");

        mTeamList.add("Chicago Bulls");
        mTeamList.add("Los Angeles Lakers");
        mTeamList.add("Memphis Grizzlies");


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new TeamListAdapter(this, mTeamList);
        mRecyclerView.setAdapter(mAdapter);

    }

//    public void searchBooks(View view) {
//        String queryString = mBookInput.getText().toString();
//        FetchStats fb = new FetchStats(mTeamRecord);
//        fb.execute(queryString);
//    }
}