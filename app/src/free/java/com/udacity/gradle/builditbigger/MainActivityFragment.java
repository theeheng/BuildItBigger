package com.udacity.gradle.builditbigger;

/**
 * Created by htan on 09/09/2015.
 */

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @InjectView(R.id.tell_joke_button)
    protected Button tellJokeButton;

    @InjectView(R.id.progressBarHolder)
    protected FrameLayout progressBarHolder;

    private JokeUtility jokeUtility;
    InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
        jokeUtility = new JokeUtility();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, root);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Resources res = getActivity().getResources();

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(res.getString(R.string.interstitial_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                jokeUtility.TellJokeButtonClick(getActivity(), tellJokeButton, progressBarHolder);
            }
        });

        requestNewInterstitial();

        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @OnClick(R.id.tell_joke_button)
    public void onTellJokeButtonClick(View v) {

        // Perform action on click
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            jokeUtility.TellJokeButtonClick(getActivity(), v, progressBarHolder);
        }
    }

}
