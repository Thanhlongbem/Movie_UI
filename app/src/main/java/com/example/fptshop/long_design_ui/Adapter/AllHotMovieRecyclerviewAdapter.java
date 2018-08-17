package com.example.fptshop.long_design_ui.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.Object.ObAllHotMovie;
import com.example.fptshop.long_design_ui.R;

import java.util.List;

public class AllHotMovieRecyclerviewAdapter extends RecyclerView.Adapter<AllHotMovieRecyclerviewAdapter.MyViewHolder> {
    Context mContext;
    List<ObAllHotMovie> mData;

    public AllHotMovieRecyclerviewAdapter(Context mContext, List<ObAllHotMovie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_all_hot_movie, viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imgAllHotMovie1.setImageResource(mData.get(i).getImgAllHotMovie1());
        myViewHolder.tvAllHotMovie1.setText(mData.get(i).getTvAllHotMovie1());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAllHotMovie1;
        private TextView tvAllHotMovie1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAllHotMovie1 = itemView.findViewById(R.id.imgAllHotMovie1);
            tvAllHotMovie1 = itemView.findViewById(R.id.tvAllHotMovie1);
;
        }

    }

}
