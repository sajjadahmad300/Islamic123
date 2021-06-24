package com.mynew.muslimapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

public class AdhanDikrActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout content;
   // private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getSharedPreferences(MainActivity.THEME_KEY,0);
//        int thm=AboutUs.getCurrentTheme(prefs);
  //      AboutUs.setCurrentTheme(this, thm);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhan_dikr);

        content=findViewById(R.id.contentlayout);
        //load AD
//        mAdView = findViewById(R.id.adVieww);


        ArrayList<Fadl> AdhanDikrList = new ArrayList<>();
        AdhanDikrList.add(new Fadl(getString(R.string.adhan1), getString(R.string.adhan1e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan2), getString(R.string.adhan2e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan3), getString(R.string.adhan3e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan4), getString(R.string.adhan4e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan5), getString(R.string.adhan5e)));
        AdhanDikrList.add(new Fadl(getString(R.string.adhan6), getString(R.string.adhan6e)));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FadlAdapter(AdhanDikrList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
