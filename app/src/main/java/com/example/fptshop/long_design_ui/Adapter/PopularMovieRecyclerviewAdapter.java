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
import android.widget.Toast;


import com.example.fptshop.long_design_ui.Object.ObMoviePopular;
import com.example.fptshop.long_design_ui.R;
import com.example.fptshop.long_design_ui.activity.AllHotMovie;
import com.example.fptshop.long_design_ui.activity.AllPopularMovie;
import com.example.fptshop.long_design_ui.activity.DetailMovieActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PopularMovieRecyclerviewAdapter extends RecyclerView.Adapter<PopularMovieRecyclerviewAdapter.MyViewHolder> {
    Context mContext;
    List<ObMoviePopular> mData;

    public static int TYPE_NORMAL = 0;
    public static int TYPE_MORE = 1;

    public PopularMovieRecyclerviewAdapter(Context mContext, List<ObMoviePopular> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public PopularMovieRecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v;

        if (viewType == TYPE_NORMAL) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_movie_popular, viewGroup, false);
        } else {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_more, viewGroup, false);
        }

        PopularMovieRecyclerviewAdapter.MyViewHolder vHolder = new PopularMovieRecyclerviewAdapter.MyViewHolder(v);
        return vHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull PopularMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        if (myViewholder.getItemViewType() == TYPE_NORMAL) {
            layoutNormalItem(myViewholder, position);
        } else {
            layoutMoreItem(myViewholder, position);
        }


    }

    public void layoutNormalItem(@NonNull PopularMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        final ObMoviePopular obMoviePopular = mData.get(position);
        myViewholder.tvnameMoviePopular1.setText(mData.get(position).getTitle());

        Picasso.with(mContext)
                .load(mData.get(position).getThumbnailUrl())
                .into(myViewholder.imgPopular1);

        myViewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivities(new Intent[]{intent});
            }
        });

    }

    public void layoutMoreItem(@NonNull PopularMovieRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        myViewholder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Xét khi click more sẽ nhảy sang activity khác
                Context context = view.getContext();
                Intent intent = new Intent(context, AllPopularMovie.class);
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
        private ImageView imgPopular1;
        private TextView tvnameMoviePopular1;
        View view;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPopular1 = itemView.findViewById(R.id.imgPopular1);
            tvnameMoviePopular1 = itemView.findViewById(R.id.nameMoviePopular1);
            this.view = itemView;
        }
    }


}
