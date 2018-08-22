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

import com.example.fptshop.long_design_ui.Object.ObAllPopularMovie;
import com.example.fptshop.long_design_ui.R;
import com.example.fptshop.long_design_ui.activity.DetailMovieActivity;

import java.util.List;

public class AllPopularMovieRecyclerviewAdapter extends RecyclerView.Adapter<AllPopularMovieRecyclerviewAdapter.MyViewHolder> {
    Context mContext;
    List<ObAllPopularMovie> mData;

    public AllPopularMovieRecyclerviewAdapter(Context mContext, List<ObAllPopularMovie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_all_popular_movie, viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imgAllPopularMovie.setImageResource(mData.get(i).getImgAllPopularMovie());
        myViewHolder.tvAllPopularMovie.setText(mData.get(i).getTvAllPopularMovie());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAllPopularMovie;
        private TextView tvAllPopularMovie;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAllPopularMovie = itemView.findViewById(R.id.imgAllPopularMovie);
            tvAllPopularMovie = itemView.findViewById(R.id.tvAllPopularMovie);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailMovieActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivities(new Intent[]{intent});
                }
            });
        }

    }
}
