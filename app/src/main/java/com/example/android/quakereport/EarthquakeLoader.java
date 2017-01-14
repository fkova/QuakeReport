package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context,String url) {
        super(context);
         mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        URL url = QueryUtils.createUrl(mUrl);

        String jsonResponse = "";

        try {
            jsonResponse = QueryUtils.makeHttpRequest(url);
            //Log.d(LOG_TAG,jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return QueryUtils.extractEarthquakes(jsonResponse);
    }
}
