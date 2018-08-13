package com.example.fptshop.long_design_ui.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fptshop.long_design_ui.Object.ObMovieNewFeed;
import com.example.fptshop.long_design_ui.R;

import java.util.List;

public class NewFeedMovieRecyclerviewAdapter extends RecyclerView.Adapter<NewFeedMovieRecyclerviewAdapter.MyViewHolder> {
        Context mContext;
        List<ObMovieNewFeed> mData;


    public NewFeedMovieRecyclerviewAdapter(Context mcontext, List<ObMovieNewFeed> mData) {
        this.mContext = mcontext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_new_feed, viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imgNF1.setImageResource(mData.get(i).getImgNewFeed1());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgNF1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNF1 = (ImageView)itemView.findViewById(R.id.imgnf1);
        }

    }






}
