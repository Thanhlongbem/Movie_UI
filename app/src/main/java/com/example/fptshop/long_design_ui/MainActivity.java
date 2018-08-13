package com.example.fptshop.long_design_ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.fptshop.long_design_ui.Adapter.ViewPageAdapter;
import com.example.fptshop.long_design_ui.Fragment.FragmentMovie;
import com.example.fptshop.long_design_ui.Fragment.FragmentTV;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);
        viewPager = (ViewPager)findViewById(R.id.viewpager_id);
        adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentMovie(), "Movie");
        adapter.AddFragment(new FragmentTV(),"TV");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
