package com.example.fptshop.long_design_ui.Adapter;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

public class HotMovieMovieRecyclerviewAdapter extends RecyclerView.Adapter<HotMovieMovieRecyclerviewAdapter.MyViewHolder>{
    Context mContext;
    List<ObMovieHotMovie> mData;

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
            v = LayoutInflater.from(mContext).inflate(R.layout.item_hot_movie, viewGroup, false);
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

    public void layoutNormalItem(@NonNull HotMovieMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        final ObMovieHotMovie obMovieHotMovie = mData.get(position);

        myViewholder.imgHotMovie.setImageResource(mData.get(position).getImgHotMovie());
        myViewholder.tvHotMovie.setText(mData.get(position).getTvHotMovie());
    }

    public void layoutMoreItem(@NonNull HotMovieMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        myViewholder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AllHotMovie.class);
                context.startActivity(intent);
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
            imgHotMovie = itemView.findViewById(R.id.imgHotMovie);
            tvHotMovie = itemView.findViewById(R.id.tvHotMovie);
            this.view = itemView;

        }
    }
}
