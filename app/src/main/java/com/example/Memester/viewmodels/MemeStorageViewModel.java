package com.example.Memester.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.Memester.Storage.MemeFactory;
import com.example.Memester.models.Meme;

import java.util.List;

public class MemeStorageViewModel extends AndroidViewModel {
    private MemeFactory memeFactory;

    public MemeStorageViewModel(@NonNull Application application) {
        super(application);
        memeFactory = MemeFactory.getInstance(application);
    }

    public LiveData<List<Meme>> getAllMemes() {
        return memeFactory.getAll();
    }

    public void insert(Meme meme) {
        memeFactory.insertMeme(meme);
    }
}
