package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

/**
 * Created by htan on 08/09/2015.
 */
public class JokeEndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private Context context;
    private IJokeUtility jokeUtility;
    private View button;

    JokeEndpointsAsyncTask(Context ctxt, IJokeUtility ju, View btn)
    {
        this.context = ctxt;
        this.jokeUtility = ju;
        this.button = btn;
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

        this.button.setEnabled(true);
    }
}
