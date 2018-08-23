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

import com.example.fptshop.long_design_ui.Object.ObAllHotMovie;
import com.example.fptshop.long_design_ui.R;
import com.example.fptshop.long_design_ui.activity.DetailMovieActivity;
import com.squareup.picasso.Picasso;

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
        final ObAllHotMovie obAllHotMovie = mData.get(i);
        myViewHolder.tvAllHotMovie1.setText(mData.get(i).getTitle());

        Picasso.with(mContext)
                .load(mData.get(i).getThumbnailUrl())
                .into(myViewHolder.imgAllHotMovie1);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivities(new Intent[]{intent});
            }
        });


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
