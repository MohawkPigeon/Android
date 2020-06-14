package com.example.Memester.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MemeList implements Serializable {

    @SerializedName("memes")
    @Expose List<Meme> memeList;

    public MemeList(List<Meme> memeList) {
        this.memeList = memeList;
    }

    public List<Meme> getMemeList() {
        return memeList;
    }
}
