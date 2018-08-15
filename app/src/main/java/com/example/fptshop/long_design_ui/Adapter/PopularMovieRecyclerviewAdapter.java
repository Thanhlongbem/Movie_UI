package com.example.fptshop.long_design_ui.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.fptshop.long_design_ui.Object.ObMoviePopular;
import com.example.fptshop.long_design_ui.R;

import java.util.List;

public class PopularMovieRecyclerviewAdapter extends RecyclerView.Adapter<PopularMovieRecyclerviewAdapter.MyViewHolder> {
    Context mContext;
    List<ObMoviePopular> mData;

    public PopularMovieRecyclerviewAdapter(Context mContext, List<ObMoviePopular> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_popular, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull PopularMovieRecyclerviewAdapter.MyViewHolder myViewholder, int i) {
        myViewholder.imgPopular1.setImageResource(mData.get(i).getImgPopular1());
        myViewholder.nameMoviePopular1.setText(mData.get(i).getNameMoviePopular1());
        myViewholder.imgPopular2.setImageResource(mData.get(i).getImgPopular2());
        myViewholder.nameMoviePopular2.setText(mData.get(i).getNameMoviePopular2());
        myViewholder.imgPopular3.setImageResource(mData.get(i).getImgPopular3());
        myViewholder.nameMoviePopular3.setText(mData.get(i).getNameMoviePopular3());
        myViewholder.imgPopular4.setImageResource(mData.get(i).getImgPopular4());
        myViewholder.nameMoviePopular4.setText(mData.get(i).getNameMoviePopular4());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPopular1;
        private TextView nameMoviePopular1;
        private ImageView imgPopular2;
        private TextView nameMoviePopular2;
        private ImageView imgPopular3;
        private TextView nameMoviePopular3;
        private ImageView imgPopular4;
        private TextView nameMoviePopular4;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPopular1 = itemView.findViewById(R.id.imgPopular1);
            nameMoviePopular1 = itemView.findViewById(R.id.nameMoviePopular1);
            imgPopular2 = itemView.findViewById(R.id.imgPopular2);
            nameMoviePopular2 = itemView.findViewById(R.id.nameMoviePopular2);
            imgPopular3 = itemView.findViewById(R.id.imgPopular3);
            nameMoviePopular3 = itemView.findViewById(R.id.nameMoviePopular3);
            imgPopular4 = itemView.findViewById(R.id.imgPopular4);
            nameMoviePopular4 = itemView.findViewById(R.id.nameMoviePopular4);
        }
    }


}
