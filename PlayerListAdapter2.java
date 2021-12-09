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

public class PlayerListAdapter2 extends
        RecyclerView.Adapter<PlayerListAdapter2.WordViewHolder>{
    private LayoutInflater mInflater;
    private LinkedList<String> mPlayerListHeat;
    private Context context;


    public PlayerListAdapter2(Context context, LinkedList<String> playerListHeat) {
        mInflater = LayoutInflater.from(context);
        mPlayerListHeat = playerListHeat;
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
        String mCurrent = mPlayerListHeat.get(position);
        holder.mPlayerListView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mPlayerListHeat.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView mPlayerListView;
        private PlayerListAdapter2 adapter;

        public WordViewHolder(View itemView, PlayerListAdapter2 adapter) {
            super(itemView);
            mPlayerListView = itemView.findViewById(R.id.players);
            this.adapter = adapter;

        }


    }

}