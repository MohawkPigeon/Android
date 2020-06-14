package com.example.Memester.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.Memester.models.DataList;
import com.example.Memester.models.Meme;
import com.example.Memester.repositories.MemeRepository;

public class MemeViewModel extends ViewModel {

    MemeRepository repository;

    public MemeViewModel(){
        repository = MemeRepository.getInstance();
    }

    public LiveData<Meme> getMeme() {
        return repository.getMeme();
    }

    public void updateMeme(String s) {
        repository.updateMeme(s);
    }

    public LiveData<DataList> getDataList() {
        return repository.getDatalist();
    }

    public void updateAllMeme() {
        repository.updateAllMeme();
    }
}

