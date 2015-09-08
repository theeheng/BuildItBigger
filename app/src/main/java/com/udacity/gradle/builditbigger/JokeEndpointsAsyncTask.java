package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.hengtan.nanodegreeapp.jokebackend.jokeApi.JokeApi;
import com.hengtan.nanodegreeapp.jokedisplaylibrary.JokeDisplayActivity;

import java.io.IOException;

/**
 * Created by htan on 08/09/2015.
 */
public class JokeEndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private Context context;
    private IJokeUtility jokeUtility;

    JokeEndpointsAsyncTask(Context ctxt, IJokeUtility ju)
    {
        this.context = ctxt;
        this.jokeUtility = ju;
    }
    @Override
    protected String doInBackground(Void... params) {
        return jokeUtility.getJoke("jokeendpoint.appspot.com");
    }

    @Override
    protected void onPostExecute(String result) {

        if(result != null) {
            jokeUtility.displayJoke(context, result);
        }
        else
        {
            Resources res = context.getResources();

            Toast toastMessage = Toast.makeText(context,
                    res.getString(R.string.server_unavailable),
                    Toast.LENGTH_LONG);

            toastMessage.show();
        }
    }
}
