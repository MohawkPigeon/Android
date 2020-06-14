package com.example.Memester.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.Memester.adapters.MyAdaptor;

import java.util.ArrayList;
import java.util.List;

public class MyViewHolderRepository {

    private static MyViewHolderRepository instance;
    private ArrayList<MyAdaptor.MyViewHolder> dataSet = new ArrayList<>();

    public static MyViewHolderRepository getInstance(){
        if (instance == null){
            instance = new MyViewHolderRepository();
        }
        return instance;
    }

    public MutableLiveData<List<MyAdaptor.MyViewHolder>> getMyViewHolders(){
        setMyViewHolders();

        MutableLiveData<List<MyAdaptor.MyViewHolder>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }


    private void setMyViewHolders() {


    }
}
