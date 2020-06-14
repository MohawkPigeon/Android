package com.example.Memester.Activitys;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.Memester.R;
import com.example.Memester.Storage.MemeFactory;
import com.example.Memester.models.Meme;
import com.example.Memester.viewmodels.MemeViewModel;

public class EditMemeView extends AppCompatActivity {

    EditText editText;
    ImageView imageView;
    MemeViewModel viewModel;
    Button button;
    Meme meme1;

    public Meme getMeme() {
        return meme1;
    }

    public void setMeme(Meme meme) {
        this.meme1 = meme;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MemeFactory memeFactory = new MemeFactory(getApplication());
                memeFactory.insertMeme(meme1);
                System.out.println(memeFactory.getAllMemes().size());

            }
        });


         */

        setContentView(R.layout.home_screen);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);

        viewModel = new ViewModelProvider(this).get(MemeViewModel.class);
        viewModel.getMeme().observe(this, new Observer<Meme>() {
            @Override
            public void onChanged(Meme meme) {
                //memeFactory.insertMeme(meme);
                setMeme(meme);
                Glide.with(EditMemeView.this).load(meme.getUrl()).into(imageView);
            }
        });
    }

    public void updateMeme(View view) {
        viewModel.updateMeme(editText.getText().toString());
    }

    public void saveMeme(View view) {
        MemeFactory memeFactory = new MemeFactory(getApplication());
        if(meme1!= null){
            memeFactory.insertMeme(meme1);
        }

        System.out.println(memeFactory.getAllMemes().size());
    }

}


