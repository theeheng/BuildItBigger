package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

/**
 * Created by htan on 08/09/2015.
 */
public interface IJokeUtility {
    void DisplayJoke(Context context, String joke);
    String getJoke(String endPointServer, HttpTransport httpTransport, JsonFactory jsonFactory);
    void TellJokeButtonClick(Context context, View view, FrameLayout progressBarHolder);
}
