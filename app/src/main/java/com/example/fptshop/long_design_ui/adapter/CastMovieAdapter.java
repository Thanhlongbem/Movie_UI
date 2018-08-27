package com.example.fptshop.long_design_ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.object.ObCast;
import com.example.fptshop.long_design_ui.R;

import java.util.List;

public class CastMovieAdapter extends RecyclerView.Adapter<CastMovieAdapter.MyViewHolder> {
    Context mContext;
    List<ObCast> mData;


    public CastMovieAdapter(Context mContext, List<ObCast> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_cast, viewGroup,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tvNameCast.setText(mData.get(i).getNameCast());
        myViewHolder.imgCast.setImageResource(mData.get(i).getImageCast());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgCast;
        private TextView tvNameCast;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCast = itemView.findViewById(R.id.imgCast);
            tvNameCast = itemView.findViewById(R.id.tvNameCast);
        }
    }
}
