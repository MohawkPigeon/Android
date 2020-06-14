package com.example.Memester.Activitys;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Memester.R;
import com.example.Memester.adapters.ApiAdaptor;
import com.example.Memester.models.DataList;
import com.example.Memester.viewmodels.MemeViewModel;

public class RecyclerViewView extends AppCompatActivity {

    MemeViewModel viewModel;

    public RecyclerViewView(){};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_row);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        viewModel = new ViewModelProvider(this).get(MemeViewModel.class);
        final ApiAdaptor apiAdaptor = new ApiAdaptor();
        apiAdaptor.setGlide(Glide.with(this));
        recyclerView.setAdapter(apiAdaptor);

        viewModel.updateAllMeme();
        viewModel.getDataList().observe(this, new Observer<DataList>() {
            @Override
            public void onChanged(DataList dataList) {

                apiAdaptor.setMemeList(dataList.getDataList().getMemeList());
            }
        });

    }

    public void updateAllMeme(View view) {
        viewModel.updateAllMeme();
    }

}
