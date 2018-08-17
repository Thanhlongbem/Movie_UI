package com.example.fptshop.long_design_ui.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fptshop.long_design_ui.Adapter.TVFirstRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Object.ObTVFirst;
import com.example.fptshop.long_design_ui.R;
import com.example.fptshop.long_design_ui.activity.AllTVProgram;

import java.util.List;

public class FragmentTV extends Fragment {
    View v;
    private RecyclerView tvFirstRecyclerview;

    private List<ObTVFirst> lstObTVFirst;

    public FragmentTV() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tv_fragment,container,false);

        TVFirstRecyclerviewAdapter tvFirstRecyclerviewAdapter = new TVFirstRecyclerviewAdapter(getContext(),lstObTVFirst);



        return v;
    }
}
