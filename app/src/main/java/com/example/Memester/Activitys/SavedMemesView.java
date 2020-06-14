package com.example.Memester.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Memester.R;
import com.example.Memester.Storage.MemeFactory;
import com.example.Memester.adapters.MyAdaptor;
import com.example.Memester.models.Meme;

import java.util.List;

public class SavedMemesView extends AppCompatActivity {

    public String s1[], s2[];
    public int images[] = {R.drawable.reverse_cat_meme,R.drawable.truck_san,R.drawable.clown,R.drawable.download3,R.drawable.memewoman};
   /*
    public List liststring1;
    public List liststring2;
    public List listImages;

    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        /*
        MemeFactory memeFactory = new MemeFactory(getApplication());
        List<Meme> memes = memeFactory.getAllMemes();
        for(int i = 0; i< memes.size(); i++){

            listImages.add(memes.get(i).url);
            liststring1.add(memes.get(i).id);
            liststring2.add(memes.get(i).name);
        }
        System.out.println(memeFactory.getAllMemes().size());
         */

        s1 = getResources().getStringArray(R.array.memes);
        s2 = getResources().getStringArray(R.array.description);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MyAdaptor myAdaptor = new MyAdaptor(this, s1,s2,images);
        //MyAdaptor myAdaptor = new MyAdaptor(this, liststring1,liststring2,listImages);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdaptor);

    }





}

