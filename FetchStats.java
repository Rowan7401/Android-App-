package com.example.nbastatsapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchStats extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mPPG;
    private WeakReference<TextView> mShootingPercentage;
    private WeakReference<TextView> mRebounds;
    private WeakReference<TextView> mAssists;


    FetchStats(TextView ppg, TextView sp, TextView reb, TextView ast) {
        this.mPPG = new WeakReference<>(ppg);
        this.mShootingPercentage = new WeakReference<>(sp);
        this.mRebounds = new WeakReference<>(reb);
        this.mAssists = new WeakReference<>(ast);
    }

    protected String getStatsInfo(String query) throws IOException {
        //Google Books API URL
        String apiURL = "https://www.balldontlie.io/api/v1/season_averages?season=2021&player_ids[]=";
        //Append query
        // String apiURL = "https://quotable.io/quotes?page=1";
        apiURL += query;

        //Make connection to API
        URL requestURL = new URL(apiURL);
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
        Log.d("FetchBookTagJsonString", jsonString);

        return jsonString;


    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d("FetBookTag","Inside Fetchbook thread");
        String jsonString = null;
        //method that connects to API throws an exception
        //must use try catch block to call it
        try {
            jsonString = getStatsInfo(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @Override
    protected void onPostExecute(String s) {
        //this method updates the UI
        //updates the TextViews
        super.onPostExecute(s);
        double pts = 0.0;
        double sp = 0.0;
        double reb = 0.0;
        double ast = 0.0;
        JSONObject jsonObject = null;
        JSONArray itemsArray = null;
        int i = 0;
        try {
            //convert jsonString to jsonObject
            jsonObject = new JSONObject(s);
            //get json array
            itemsArray = jsonObject.getJSONArray("data");
            //itemsArray = jsonObject.getJSONArray("results");
            //loop through array until you find an author and title
            for (i = 0; i < itemsArray.length(); i++) {
                // Get a json object from array
                JSONObject stats = itemsArray.getJSONObject(i);
                //get volumeInfo key
                //JSONObject volumeInfo = book.getJSONObject("pts");

                //volumeInfo object has title and author string
                sp = stats.getDouble("fg_pct");
                pts = stats.getDouble("pts");
                reb = stats.getDouble("reb");
                ast = stats.getDouble("ast");
                Log.d("FetchBook","PPG is "+pts);
                //title = book.getString("content");
                //authors = book.getString("author");

                //once you find a title and author update UI TextViews
                if (pts != 0.0) {
                    mPPG.get().setText(Double.toString(pts) + " Points per game");
                    mShootingPercentage.get().setText(Double.toString(sp) + " Shooting %");
                    mRebounds.get().setText(Double.toString(reb) + " Rebounds per game" );
                    mAssists.get().setText(Double.toString(ast) + " Assists per game");

                } else {
                    // If none are found, update the UI to
                    // show failed results.
                    mPPG.get().setText("No results");
                }
                // Move to the next item.
                i++;
            }
        } catch (Exception e) {
            mPPG.get().setText("No results");
            e.printStackTrace();
        }


    }
}