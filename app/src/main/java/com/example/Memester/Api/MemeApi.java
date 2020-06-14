package com.example.Memester.Api;

import com.example.Memester.models.DataList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MemeApi {

    @GET("get_memes")
    Call<DataList> getMeme();

    @POST("caption_image")
    Call<DataList> postMeme();


}