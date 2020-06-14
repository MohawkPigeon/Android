package com.example.Memester.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.Memester.Api.MemeApi;
import com.example.Memester.Api.ServiceGenerator;
import com.example.Memester.models.DataList;
import com.example.Memester.models.Meme;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemeRepository {

    private static MemeRepository instance;

    private MutableLiveData<Meme> meme;

    private MutableLiveData<DataList> datalist;

    private MemeRepository() {
        meme = new MutableLiveData<>();
        datalist = new MutableLiveData<>();
    }

    public static synchronized MemeRepository getInstance() {
        if (instance == null) {
            instance = new MemeRepository();
        }
        return instance;
    }

    public MutableLiveData<DataList> getDatalist() {
        return datalist;
    }

    public LiveData<Meme> getMeme() {
        return meme;
    }

    public void updateMeme(final String memeName) {
        MemeApi memeApi = ServiceGenerator.getMemeApi();
        Call<DataList> call = memeApi.getMeme();
        call.enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                if (response.code() == 200) {
                    meme.setValue(response.body().getDataList().getMemeList().get(Integer.parseInt(memeName)));
                }
            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
                System.out.println("error: " + t);
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void updateAllMeme() {
        MemeApi memeApi = ServiceGenerator.getMemeApi();
        Call<DataList> call = memeApi.getMeme();
        call.enqueue(new Callback<DataList>() {
            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                if (response.code() == 200) {
                    datalist.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
                System.out.println("error: " + t);
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
