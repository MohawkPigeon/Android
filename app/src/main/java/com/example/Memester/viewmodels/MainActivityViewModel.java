package com.example.Memester.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.Memester.adapters.MyAdaptor;
import com.example.Memester.repositories.MyViewHolderRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<MyAdaptor.MyViewHolder>> mMyViewHolders;
    private MyViewHolderRepository mRepo;

    public void init(){
        if(mMyViewHolders != null){
            return;
        }
        mRepo = MyViewHolderRepository.getInstance();
        mMyViewHolders = mRepo.getMyViewHolders();
    }

    public LiveData<List<MyAdaptor.MyViewHolder>> getMyViewHolders(){
        return mMyViewHolders;
    }
}
