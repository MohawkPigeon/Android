package com.example.Memester.Storage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.Memester.MainActivity;
import com.example.Memester.models.Meme;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MemeFactory {

    private MemeDao memeDao;
    private static MemeFactory memeFactory;
    private LiveData<List<Meme>> listLiveData;
    private AppDatabase database;

    public MemeFactory(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        memeDao = database.MemeDao();

    }


    public static synchronized MemeFactory getInstance(Application application) {
        if (memeFactory == null) {
            memeFactory = new MemeFactory(application);
        }
        return memeFactory;
    }

    public LiveData<List<Meme>> getAll() {
        return listLiveData;
    }

    public void insertMeme(Meme meme){

        InsertAsyncTask insertAsyncTask = new InsertAsyncTask(memeDao);
        insertAsyncTask.execute(meme);
    }

    public List<Meme> getAllMemes(){

        getAllAsyncTask getAllAsyncTask = new getAllAsyncTask();
        getAllAsyncTask.execute();
        try {
            return getAllAsyncTask.get();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    class InsertAsyncTask extends AsyncTask<Meme, Void, Void> {

        private MemeDao memeDao;

        private InsertAsyncTask(MemeDao memeDao) {
            this.memeDao = memeDao;
        }

        @Override
        protected Void doInBackground(Meme... meme){

            memeDao.insert(meme);

            return null;
        }
    }

    class getAllAsyncTask extends AsyncTask<Void, Void, List<Meme>> {

        @Override
        protected List<Meme> doInBackground(Void... voids){

            return memeDao.getAll();
        }

    }


}
