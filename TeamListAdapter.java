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

public class TeamListAdapter extends
        RecyclerView.Adapter<TeamListAdapter.WordViewHolder>{
    private LayoutInflater mInflater;
    private LinkedList<String> mTeamList;
    private LinkedList<String> mPlayerList;
    private Context context;


    public TeamListAdapter(Context context,
                         LinkedList<String> teamList, LinkedList<String> playerList) {

        mInflater = LayoutInflater.from(context);
        mTeamList = teamList;
        mPlayerList = playerList;
        this.context = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.team_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mTeamList.get(position);
        String mCurrent2 = mPlayerList.get(position);
        holder.mTeamListView.setText(mCurrent);
        holder.mPlayerListView.setText(mCurrent2);
    }

    @Override
    public int getItemCount() {
        return mTeamList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTeamListView;
        private TextView mPlayerListView;
        private TeamListAdapter adapter;

        public WordViewHolder(View itemView, TeamListAdapter adapter) {
            super(itemView);
            mTeamListView = itemView.findViewById(R.id.teams);
            mPlayerListView = itemView.findViewById(R.id.players);
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