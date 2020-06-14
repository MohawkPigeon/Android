package com.example.Memester.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.Memester.MainActivity;
import com.example.Memester.R;
import com.example.Memester.models.DataList;
import com.example.Memester.models.Meme;
import com.example.Memester.models.MemeList;

import java.util.ArrayList;
import java.util.List;


public class ApiAdaptor extends RecyclerView.Adapter<ApiAdaptor.ApiViewHolder> {

    //DataList dataList;
    //MemeList memeList;

    private List<Meme> memeList = new ArrayList<>();

    private RequestManager glide;

    private Context context;

    public ApiAdaptor(List<Meme> memeList, RequestManager glide, Context context) {
        this.memeList = memeList;
        this.glide = glide;
        this.context = context;
    }

    public ApiAdaptor(){};

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        glide.load(memeList.get(position).getUrl()).into(holder.myImage);

    }

    @Override
    public int getItemCount() {
        //return 1;
        return memeList.size();
    }

    public void setMemeList(List<Meme> memeList) {
        this.memeList = memeList;
        notifyDataSetChanged();
    }

    public RequestManager getGlide() {
        return glide;
    }

    public void setGlide(RequestManager glide) {
        this.glide = glide;
    }

    public List<Meme> getMemeList() {
        return memeList;
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder{

        public ImageView myImage;

        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.myImageView);
        }
    }


}

