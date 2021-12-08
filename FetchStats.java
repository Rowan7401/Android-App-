package com.example.nbastatsapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchStats extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mThreePointPercentage;
    private WeakReference<TextView> mPPG;
    private WeakReference<TextView> mRebounds;
    private WeakReference<TextView> mShootingPercentage;
    private WeakReference<TextView> mFreeThrowPercentage;
    private WeakReference<TextView> mAssists;
    private WeakReference<TextView> mSteals;
    private WeakReference<TextView> mBlocks;


    FetchStats(TextView threePointPercentage, TextView ppg, TextView rebounds,
               TextView shootingPercentage, TextView freeThrowPercentage,
               TextView assists, TextView steals, TextView blocks) throws IOException {
        this.mThreePointPercentage = new WeakReference<>(threePointPercentage);
        this.mPPG = new WeakReference<>(ppg);
        this.mRebounds = new WeakReference<>(rebounds);
        this.mShootingPercentage = new WeakReference<>(shootingPercentage);
        this.mFreeThrowPercentage = new WeakReference<>(freeThrowPercentage);
        this.mAssists = new WeakReference<>(assists);
        this.mSteals = new WeakReference<>(steals);
        this.mBlocks = new WeakReference<>(blocks);
    }

    protected String getStats(String string) throws IOException {
        //Ball dont lie API URL
        String apiURL = "https://www.balldontlie.io/api/v1/season_averages?season=2021&player_ids[]=4";


        //Make connection to API
        URL requestURL = null;
        try {
            requestURL = new URL(apiURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = (HttpURLConnection) requestURL.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        //Receive the response
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //Create a String with the reponse
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        String jsonString = builder.toString();
        Log.d("FetchStatsTagJsonString", jsonString);

        return jsonString;
    }


    @Override
    protected String doInBackground(String... strings) {
        String jsonString = null;
        try {
            jsonString = getStats(strings[0]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String fg3_pct = null;
        String pts = null;
        String reb = null;
        String fg_pct = null;
        String ft_pct = null;
        String stl = null;
        String blk = null;
        String ast = null;
        JSONObject jsonObject = null;
        JSONArray itemsArray = null;
        int i = 0;
        try {
            jsonObject = new JSONObject(s);
            itemsArray = jsonObject.getJSONArray("items");
            while (i < itemsArray.length() && (fg3_pct == null && pts == null
                    && reb == null && fg_pct == null && ft_pct == null &&
                    stl == null && blk == null && ast == null)) {
                JSONObject averages = itemsArray.getJSONObject(i);
                JSONObject averagesInfo = averages.getJSONObject("season_averages");
                fg3_pct = averagesInfo.getString("fg3_pct");
                pts = averagesInfo.getString("pts");
                reb = averagesInfo.getString("reb");
                fg_pct = averagesInfo.getString("fg_pct");
                ft_pct = averagesInfo.getString("ft_pct");
                stl = averagesInfo.getString("stl");
                blk = averagesInfo.getString("blk");
                ast = averagesInfo.getString("ast");
                mThreePointPercentage.get().setText(fg3_pct);
                mPPG.get().setText(pts);
                mRebounds.get().setText(reb);
                mShootingPercentage.get().setText(fg_pct);
                mFreeThrowPercentage.get().setText(ft_pct);
                mAssists.get().setText(stl);
                mSteals.get().setText(blk);
                mBlocks.get().setText(ast);
                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
