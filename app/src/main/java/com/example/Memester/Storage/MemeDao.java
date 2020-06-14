package com.example.Memester.Storage;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.Memester.models.Meme;

import java.util.List;

@Dao
public abstract class MemeDao implements BaseDao<Meme> {

    @Query("SELECT * FROM Meme")
    public abstract List<Meme> getAll();

    @Query("SELECT * FROM Meme WHERE id IN (:MemeIds)")
    public abstract List<Meme> loadAllByIds(int[] MemeIds);

    @Query("SELECT * FROM Meme WHERE id IN (:MemeIds)")
    public abstract Meme loadById(int MemeIds);

}
