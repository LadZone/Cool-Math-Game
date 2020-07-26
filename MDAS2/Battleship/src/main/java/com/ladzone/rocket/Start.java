package com.ladzone.rocket;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static com.ladzone.rocket.R.id.btn_start;

public class Start extends AppCompatActivity {
    private Button button;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);
        button =(Button) findViewById(btn_start);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //AdView mAdView = (AdView) findViewById(R.id.adView);
      //  AdRequest adRequest = new AdRequest.Builder().build();
       // mAdView.loadAd(adRequest);


       // button = (Button)findViewById(R.id.start);
       // button =(Button) findViewById(R.id.start);

        button.setEnabled(false);
       button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showInterstitial();

                //startActivity(new Intent(Start.this, Game.class));


            }
        });

        mInterstitialAd = newInterstitialAd();
        loadInterstitial();


    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            goToNextLevel();
            //startActivity(new Intent(Start.this, Game.class));
        }
    }


    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                button.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                button.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
                // startActivity(new Intent(Start.this, Game.class));
            }
        });
        return interstitialAd;
    }

    private void loadInterstitial(){
        // Disable the next level button and load the ad.
        button.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }
    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
        // mLevelTextView.setText("Level " + (++mLevel));
        startActivity(new Intent(Start.this, Game.class));
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }


}

