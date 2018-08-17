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

import com.example.fptshop.long_design_ui.Object.ObTVFirst;
import com.example.fptshop.long_design_ui.R;
import com.example.fptshop.long_design_ui.activity.AllTVProgram;

import java.util.List;

public class TVFirstRecyclerviewAdapter extends RecyclerView.Adapter<TVFirstRecyclerviewAdapter.MyViewHolder>{
    Context mContext;
    List<ObTVFirst> mData;

    public static int TYPE_NORMAL = 0;
    public static int TYPE_MORE = 1;

    public TVFirstRecyclerviewAdapter(Context mContext, List<ObTVFirst> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public TVFirstRecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v;

        if (viewType == TYPE_NORMAL) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_tv_first, viewGroup, false);
        } else {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_more, viewGroup, false);
        }

        TVFirstRecyclerviewAdapter.MyViewHolder vHolder = new TVFirstRecyclerviewAdapter.MyViewHolder(v);
        return vHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull TVFirstRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        if (myViewholder.getItemViewType() == TYPE_NORMAL) {
            layoutNormalItem(myViewholder, position);
        } else {
            layoutMoreItem(myViewholder, position);
        }


    }




    public void layoutNormalItem(@NonNull TVFirstRecyclerviewAdapter.MyViewHolder myViewholder, int position){
        final ObTVFirst obTVFirst = mData.get(position);

        myViewholder.imgTVFirst.setImageResource(mData.get(position).getImgTVFirst());
        myViewholder.tvTVFirst.setText(mData.get(position).getNameTVFirst());
    }

    public void layoutMoreItem(@NonNull TVFirstRecyclerviewAdapter.MyViewHolder myViewholder, int position) {
        myViewholder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AllTVProgram.class);
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

    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imgTVFirst;
        private TextView tvTVFirst;
        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTVFirst = itemView.findViewById(R.id.imgTVFirst);
            tvTVFirst = itemView.findViewById(R.id.tvTVFirst);
        }
    }



}
