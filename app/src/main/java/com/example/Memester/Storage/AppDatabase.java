package com.example.Memester.Storage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.Memester.models.Meme;

@Database(entities = {Meme.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MemeDao MemeDao();

    //Singleton Pattern
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            .enableMultiInstanceInvalidation().build();
                }
            }
        }
        return INSTANCE;
    }
}
