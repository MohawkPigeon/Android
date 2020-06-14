package com.example.Memester;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.Memester.FirebaseActivity.FirebaseActivity;
import com.example.Memester.Activitys.EditMemeView;
import com.example.Memester.Activitys.RecyclerViewView;
import com.example.Memester.Activitys.SavedMemesView;
import com.example.Memester.Storage.AppDatabase;
import com.example.Memester.Storage.MemeDao;
import com.example.Memester.Storage.MemeFactory;
import com.example.Memester.adapters.ApiAdaptor;
import com.example.Memester.adapters.MyAdaptor;
import com.example.Memester.models.Meme;
import com.example.Memester.viewmodels.MainActivityViewModel;
import com.example.Memester.viewmodels.MemeViewModel;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    RecyclerView recyclerView;

    public String s1[], s2[];
    public int images[] = {R.drawable.reverse_cat_meme,R.drawable.truck_san,R.drawable.clown,R.drawable.download3,R.drawable.memewoman};


    EditText editText;
    ImageView imageView;
    MemeViewModel viewModel;

    private MainActivityViewModel mMainActivityViewModel;
    private MyAdaptor myAdaptor;
    private ApiAdaptor apiAdaptor;

    private FirebaseAuth mAuth;

    private AppDatabase db;
    private MemeDao memeDao;
    private MemeFactory memeFactory;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkIfSignedIn();

        final Context context = getApplicationContext();

        setContentView(R.layout.actual_home);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewMeme();
            }
        });

        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMemeTemplates();
            }
        });

        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSavedMemes();
            }
        });

    }


    public void updateMeme(View view) {
        viewModel.updateMeme(editText.getText().toString());
    }

    public void updateAllMeme(View view) {
        viewModel.updateAllMeme();
    }



    //Firebase login auth
    private void checkIfSignedIn() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null)
            Toast.makeText(this,"Welcome " + user.getDisplayName(), Toast.LENGTH_LONG).show();
        else
            startLoginActivity();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, FirebaseActivity.class));
        finish();
    }

    public void signOut(View v) {
        AuthUI
                .getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startLoginActivity();
                    }
                });
    }

    public void goToNewMeme() {

        Intent intent = new Intent(this, EditMemeView.class);
        startActivity(intent);
        //setContentView(R.layout.home_screen);
    }

    public void goToMemeTemplates() {

        Intent intent = new Intent(this, RecyclerViewView.class);
        startActivity(intent);
        //setContentView(R.layout.my_row);
    }

    public void goToSavedMemes() {

        Intent intent = new Intent(this, SavedMemesView.class);
        startActivity(intent);
        //setContentView(R.layout.activity_main);
    }

}
