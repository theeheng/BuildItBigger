package com.udacity.gradle.builditbigger;

import android.content.Context;

/**
 * Created by htan on 08/09/2015.
 */
public interface IJokeUtility {
    void displayJoke(Context context, String joke);
    String getJoke(String endPointServer);
}
