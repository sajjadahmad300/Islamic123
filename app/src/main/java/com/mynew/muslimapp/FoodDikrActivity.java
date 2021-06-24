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

public class FoodDikrActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout content;
//    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences prefs = getSharedPreferences(MainActivity.THEME_KEY,0);
      //  int thm=AboutUs.getCurrentTheme(prefs);
      //  AboutUs.setCurrentTheme(this, thm);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_dikr);

        content=findViewById(R.id.contentlayout);
        //load AD
        //mAdView = findViewById(R.id.adVieww);
       // AdRequest adRequest = new AdRequest.Builder()
                //.build();
      //  mAdView.loadAd(adRequest);
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//                Resources r = getResources();
//                int px = (int) TypedValue.applyDimension(
//                        TypedValue.COMPLEX_UNIT_DIP,
//                        50,
//                        r.getDisplayMetrics()
//                );
//                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                        RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT
//                );
//                content.setLayoutParams(params);
//                params.setMargins(0, px, 0, px);
//            }
//        });


        ArrayList<Fadl> FoodDikr = new ArrayList<>();
        FoodDikr.add(new Fadl(getString(R.string.food1), getString(R.string.food1e)));
        FoodDikr.add(new Fadl(getString(R.string.food2), getString(R.string.food2e)));
        FoodDikr.add(new Fadl(getString(R.string.food3), getString(R.string.food3e)));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FadlAdapter(FoodDikr);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
