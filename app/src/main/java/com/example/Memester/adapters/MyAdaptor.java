package com.example.Memester.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Memester.Activitys.EditMemeView;
import com.example.Memester.R;

import java.util.List;


public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {

    String data1[], data2[];
    int[] images;
    Context context;
/*
    public List liststring1;
    public List liststring2;
    public List listImages;



    public MyAdaptor(Context context, List liststring1, List liststring2, List listImages) {
        this.context = context;
        this.liststring1 = liststring1;
        this.liststring2 = liststring2;
        this.listImages = listImages;
    }
 */
    public MyAdaptor(Context ct, String[] s1, String[] s2, int[] img){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        Glide.with(this.context).load(images[position]).into(holder.myImage);
        //holder.myImage.setImageResource(images[position]);
        /*
        holder.myText1.setText((Integer) liststring1.get(position));
        holder.myText2.setText((Integer) liststring2.get(position));
        Glide.with(this.context).load(listImages.get(position)).into(holder.myImage);

         */
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView myText1, myText2;
        public ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myImage = itemView.findViewById(R.id.myImageView);
        }


    }


}
