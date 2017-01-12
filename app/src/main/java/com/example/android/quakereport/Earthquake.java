package com.example.android.quakereport;

public class Earthquake {
    private double mMag;
    private String mLoc;
    private long mDate;
    private String mUrl;

    public Earthquake(double mag, String loc, long date,String url) {
        this.mMag = mag;
        this.mLoc = loc;
        this.mDate = date;
        mUrl = url;
    }

    public double getMag() {
        return mMag;
    }

    public String getLoc() {
        return mLoc;
    }

    public long getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
