package com.mynew.muslimapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;

public class AboutUs extends AppCompatActivity {
//    private InterstitialAd mInterstitialAd;
//    private InterstitialAd mInterstitialAd2;
    SharedPreferences prefs;
    SharedPreferences.Editor mEditor;
    int x;
    static final String THEME_KEY = "Theme";
    Switch switchMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = getSharedPreferences(THEME_KEY,0);
        x=getCurrentTheme(prefs);
        AboutUs.setCurrentTheme(this, x);

//        mInterstitialAd = new InterstitialAd(this);
//        // TO RE-SET
//        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //test
//      //  mInterstitialAd.setAdUnitId(getString(R.string.Interstitial_Settings));
//        mInterstitialAd.loadAd(new AdRequest.Builder()
//                .build());
//        mInterstitialAd.setAdListener(new com.google.android.gms.ads.AdListener() {
//            @Override
//            public void onAdLoaded() {
//                mInterstitialAd.show();
//                super.onAdLoaded();
//            }
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setSwitch(x);
    }
//    @Override
//    public void onBackPressed() {
//        Intent intent= new Intent(this,MainActivity.class);
//
//        overridePendingTransition(0, 0);
//        startActivity(intent);
//        overridePendingTransition(0, 0);
//        mInterstitialAd2 = new InterstitialAd(this);
//        // TO RE-SET
//        //mInterstitialAd2.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //test
//      //  mInterstitialAd2.setAdUnitId(getString(R.string.Interstitial_BacktohomefromSettings));
//        mInterstitialAd2.loadAd(new AdRequest.Builder()
//                .build());
//        mInterstitialAd2.setAdListener(new com.google.android.gms.ads.AdListener() {
//            @Override
//            public void onAdLoaded() {
//                mInterstitialAd2.show();
//                super.onAdLoaded();
//            }
//        });
//        finish();
//    }

    public static int getCurrentTheme(SharedPreferences pref){
        int t = pref.getInt("Theme", R.style.AppThemee);
        return t;
    }
    public static void setCurrentTheme(Activity activity,int x){
        switch (x){
            case R.style.AppTheme:
                activity.setTheme(R.style.AppTheme);
                break;
            default:
                activity.setTheme(R.style.AppThemee);
                break;
        }
    }
    public  void setSwitch(int x){
        switchMode=findViewById(R.id.switchnightmode);
        switch (x){
            case R.style.AppTheme: switchMode.setChecked(true);
                this.setTheme(R.style.AppTheme);
                break;
            default: switchMode.setChecked(false);
                this.setTheme(R.style.AppThemee);
                break;
        }
    }
    public void SwitchedtoNightMode(View v){
        switchMode=findViewById(R.id.switchnightmode);
        prefs = getSharedPreferences(THEME_KEY,0);
        mEditor = prefs.edit();

        Intent intent = getIntent();
        if (switchMode.isChecked()){
            mEditor.putInt("Theme",R.style.AppTheme);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        }else{
            mEditor.putInt("Theme",R.style.AppThemee);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        }
        mEditor.commit();
    }
    public void privacypolicy(View v) {
        Intent intent = new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }
    public  void reportProblem(View v){
        Intent intent = new Intent(this, ReportProblem.class);
        startActivity(intent);
    }
    public void RateApp (View v){
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


}
