package com.example.Memester.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.imgflip.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static MemeApi MemeApi = retrofit.create(MemeApi.class);

    public static MemeApi getMemeApi() {
        return MemeApi;
    }
}
