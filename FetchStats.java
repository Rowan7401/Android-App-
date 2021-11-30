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
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    FetchStats(TextView titleText, TextView authorText) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
    }

    protected String getBookInfo(String query) throws IOException {
        //Google Books API URL
        String apiURL = "https://www.googleapis.com/books/v1/volumes?q=";
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
        String jsonString = null;
        try {
            jsonString = getBookInfo(strings[0]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String title = null;
        String author = null;
        JSONObject jsonObject = null;
        JSONArray itemsArray = null;
        int i = 0;
        try {
            jsonObject = new JSONObject(s);
            itemsArray = jsonObject.getJSONArray("items");
            while (i < itemsArray.length() && (author == null && title == null)) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                title = volumeInfo.getString("title");
                author = volumeInfo.getString("authors");
                mAuthorText.get().setText(author);
                mTitleText.get().setText(title);
                i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
