package com.example.fptshop.long_design_ui.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.adapter.ViewPageAdapter;
import com.example.fptshop.long_design_ui.fragment.FragmentMovie;
import com.example.fptshop.long_design_ui.fragment.FragmentTV;
import com.example.fptshop.long_design_ui.R;

import io.realm.Realm;

//TODO - can them UI list danh sach ket qua trong SearchActivity
//TODO - doi lai tab footer ve mau xanh (giong toolbar), chu mau trang
//TODO - them nut back khi scroll down (add button back when toolbar show with CollapsingToolbarLayout)
//TODO - fix ui MovieDetails
//TODO - design man Player (nghien cuu truoc ExoPlayer 2), link demo: https://video.fhan2-2.fna.fbcdn.net/v/t42.9040-2/10000000_1876867859080996_2942239991478091776_n.mp4?_nc_cat=1&efg=eyJybHIiOjMwMCwicmxhIjo0MDk2LCJ2ZW5jb2RlX3RhZyI6InNkIn0%3D&rl=300&vabr=134&oh=7e9e3a127fee470728e8cdfd536c3932&oe=5B86323E
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;
    TextView tvSearchActivity;
    Intent intent;
    AppBarLayout appBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Realm.init(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();

        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);
        viewPager = (ViewPager)findViewById(R.id.viewpager_id);
        adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentMovie(), "Movie");
        adapter.addFragment(new FragmentTV(),"TV");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        searchClick();
    }

    public void searchClick(){
        tvSearchActivity = findViewById(R.id.tvSearchActivity);
        tvSearchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
