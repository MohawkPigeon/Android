package com.example.Memester.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataList {
    @SerializedName("data")
    @Expose
    MemeList memeList;

    public DataList(MemeList memeList) {
        this.memeList = memeList;
    }

    public MemeList getDataList() {
        return memeList;
    }
}
