package com.example.fptshop.long_design_ui.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.R;
import com.example.fptshop.long_design_ui.activity.AllHotMovie;
import com.example.fptshop.long_design_ui.Object.ObMovieHotMovie;
import com.example.fptshop.long_design_ui.activity.DetailMovieActivity;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class HotMovieMovieRecyclerviewAdapter extends RecyclerView.Adapter<HotMovieMovieRecyclerviewAdapter.MyViewHolder>{
    Context mContext;
    List<ObMovieHotMovie> mData;
    public static final String IMAGE = "image";
    public static final String NAME = "name";
    public static final String SOURCE = "source";




    public static int TYPE_NORMAL = 0;
    public static int TYPE_MORE = 1;

    public HotMovieMovieRecyclerviewAdapter(Context mContext, List<ObMovieHotMovie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public HotMovieMovieRecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v;

        if (viewType == TYPE_NORMAL) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_movie_hot_movie, viewGroup, false);
        } else {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_more, viewGroup, false);
        }



        HotMovieMovieRecyclerviewAdapter.MyViewHolder vHolder = new HotMovieMovieRecyclerviewAdapter.MyViewHolder(v);
        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull HotMovieMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        if (myViewholder.getItemViewType() == TYPE_NORMAL) {
            layoutNormalItem(myViewholder, position);
        } else {
            layoutMoreItem(myViewholder, position);
        }


    }

    public void layoutNormalItem(@NonNull final MyViewHolder myViewholder, final int position) {
        final ObMovieHotMovie obMovieHotMovie = mData.get(position);
        myViewholder.tvHotMovie.setText(mData.get(position).getTitle());


        Picasso.with(mContext)
                .load(mData.get(position).getThumbnailUrl())
                .into(myViewholder.imgHotMovie);

        myViewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra("IMAGE",mData.get(position).getThumbnailUrl());
                intent.putExtra("NAME", mData.get(position).getTitle());
                intent.putExtra(SOURCE, "HotMovie");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    public void layoutMoreItem(@NonNull HotMovieMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        myViewholder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AllHotMovie.class);
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mData.size() - 1) {
            return TYPE_NORMAL;
        } else {
            return TYPE_MORE;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHotMovie;
        private TextView tvHotMovie;

        View view;


        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            //view = itemView;
            imgHotMovie = itemView.findViewById(R.id.imgHotMovie);
            tvHotMovie = itemView.findViewById(R.id.tvHotMovie);
            this.view = itemView;


        }
    }




}
