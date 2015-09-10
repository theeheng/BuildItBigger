package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.hengtan.nanodegreeapp.jokebackend.jokeApi.JokeApi;
import com.hengtan.nanodegreeapp.jokedisplaylibrary.JokeDisplayActivity;

import java.io.IOException;

/**
 * Created by htan on 08/09/2015.
 */
public class JokeUtility implements IJokeUtility {

    private static JokeApi myApiService = null;

    public void DisplayJoke(Context context, String joke)
    {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKEEXTRA, joke);
        context.startActivity(intent);
    }

    public String getJoke(String endPointServer, HttpTransport httpTransport, JsonFactory jsonFactory)
    {
        String rootUrl;

        if(endPointServer.equals("10.0.2.2:8080"))
        {
            rootUrl = "http://"+endPointServer+"/_ah/api/";
        }
        else
        {
            rootUrl = "https://"+endPointServer+"/_ah/api/";
        }

        if(myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(httpTransport, jsonFactory, null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(rootUrl)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    public void TellJokeButtonClick(Context context, View view, FrameLayout progressBarHolder){

        view.setEnabled(false);

        new JokeEndpointsAsyncTask(context, this , view, progressBarHolder).execute();
    }
}
