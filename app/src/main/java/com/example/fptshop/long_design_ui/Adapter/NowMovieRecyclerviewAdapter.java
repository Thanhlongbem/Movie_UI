package com.example.fptshop.long_design_ui.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fptshop.long_design_ui.Object.ObMovieNewFeed;
import com.example.fptshop.long_design_ui.Object.ObMovieNow;
import com.example.fptshop.long_design_ui.R;

import java.util.List;

public class NowMovieRecyclerviewAdapter extends RecyclerView.Adapter<NowMovieRecyclerviewAdapter.MyViewHolder>{
    Context mContext;
    List<ObMovieNow> mData;

    public NowMovieRecyclerviewAdapter(Context mContext, List<ObMovieNow> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_now, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imgnow1.setImageResource(mData.get(i).getImgn1());
        myViewHolder.imgnow2.setImageResource(mData.get(i).getImgn2());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgnow1;
        private ImageView imgnow2;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgnow1 = (ImageView) itemView.findViewById(R.id.imgnow1);
            imgnow2 = (ImageView) itemView.findViewById(R.id.imgnow2);
        }
    }
}
