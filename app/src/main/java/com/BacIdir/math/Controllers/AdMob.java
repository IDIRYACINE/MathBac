package com.BacIdir.math.Controllers;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Arrays;
import java.util.List;

public class AdMob {

    private final Handler mHandler ;
    private final Activity main ;

    public AdMob(Activity context , Handler handler) {
        mHandler = handler ;
        main = context ;
    }

    public AdMob(Activity context ) {
        main = context ;
        mHandler = null;
    }

    public void CreateAd() {
        MobileAds.initialize(main, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete( InitializationStatus initializationStatus) {
            }
        });
    }

    public void LoadAd() {
        //mInterstitialAd.setAdUnitId("ca-app-pub-7616920693631792/9303048879");
        List<String> testDeviceIds = Arrays.asList("F19072B8718F95EF9143056D67EBA41B");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);
        final AdRequest adRequest = new AdRequest.Builder().build();

        mHandler.post(new Runnable() {
            @Override
            public void run() { InterstitialAd.load(main, "ca-app-pub-3940256099942544/1033173712", adRequest, AdCallBack) ; }});
    }

    private InterstitialAd mInterstitialAd ;
    private final InterstitialAdLoadCallback AdCallBack = new InterstitialAdLoadCallback() {
        @Override
        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
            mInterstitialAd = interstitialAd ;
            mInterstitialAd.setFullScreenContentCallback(AdRefresher);
        }

        @Override
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            mInterstitialAd = null ;
        }

    };

    private final FullScreenContentCallback AdRefresher = new FullScreenContentCallback() {
        @Override
        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            mInterstitialAd = null;
        }

        @Override
        public void onAdDismissedFullScreenContent() {
            mInterstitialAd = null;
        }

        @Override
        public void onAdShowedFullScreenContent() {
            mInterstitialAd = null;
        }
    };

    public void Display(){
        if (mInterstitialAd!=null) { mInterstitialAd.show(main); }
    }


}