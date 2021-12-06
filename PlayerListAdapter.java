package com.example.nbastatsapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class PlayerListAdapter extends
        RecyclerView.Adapter<PlayerListAdapter.WordViewHolder>{
    private LayoutInflater mInflater;
    private LinkedList<String> mPlayerList;
    private LinkedList<String> mBullsStats;
    private Context context;


    public PlayerListAdapter(Context context, LinkedList<String> playerList, LinkedList<String> bullsStats) {
        mInflater = LayoutInflater.from(context);
        mPlayerList = playerList;
        mBullsStats = bullsStats;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.player_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mPlayerList.get(position);
        String mCurrent2 = mBullsStats.get(position);
        holder.mPlayerListView.setText(mCurrent);
        holder.mBullsStatsView.setText(mCurrent2);
    }

    @Override
    public int getItemCount() {
        return mPlayerList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mPlayerListView;
        private TextView mBullsStatsView;
        private PlayerListAdapter adapter;

        public WordViewHolder(View itemView, PlayerListAdapter adapter) {
            super(itemView);
            mPlayerListView = itemView.findViewById(R.id.players);
            mBullsStatsView = itemView.findViewById(R.id.stats);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, bulls_detail.class);
            context.startActivity(intent);
        }

    }

}