package com.example.Memester.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "Meme")
public class Meme implements Serializable {

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name= "id")
    @Expose public int id;

    @SerializedName("name")
    @ColumnInfo(name= "name")
    @Expose public String name;

    @SerializedName("url")
    @ColumnInfo(name= "url")
    @Expose public String url;

    @SerializedName("width")
    @ColumnInfo(name= "width")
    @Expose public int width;

    @SerializedName("height")
    @ColumnInfo(name= "height")
    @Expose public int height;

    @SerializedName("box_count")
    @ColumnInfo(name= "box_count")
    @Expose public int box_count;

    public Meme(int id, String name, String url, int width, int height, int box_count) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.width = width;
        this.height = height;
        this.box_count = box_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBox_count() {
        return box_count;
    }

    public void setBox_count(int box_count) {
        this.box_count = box_count;
    }
}
