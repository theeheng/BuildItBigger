package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

/**
 * Created by htan on 08/09/2015.
 */
public class JokeEndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private Context mContext;
    private IJokeUtility mJokeUtility;
    private View mTellJokeButton;
    private FrameLayout mProgressBarHolder;

    JokeEndpointsAsyncTask(Context ctxt, IJokeUtility ju, View btn, FrameLayout progressBarHolder)
    {
        this.mContext = ctxt;
        this.mJokeUtility = ju;
        this.mTellJokeButton = btn;
        this.mProgressBarHolder = progressBarHolder;
    }
    @Override
    protected String doInBackground(Void... params) {

        ((Activity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressBarHelper.ShowProgressBar(mProgressBarHolder);
            }
        });

        Resources res = mContext.getResources();

        return mJokeUtility.getJoke(res.getString(R.string.joke_end_point_server), AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory());
    }

    @Override
    protected void onPostExecute(String result) {

        ((Activity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressBarHelper.HideProgressBar(mProgressBarHolder);
            }
        });

        if(result != null) {
            mJokeUtility.DisplayJoke(mContext, result);
        }
        else
        {
            Resources res = mContext.getResources();

            Toast toastMessage = Toast.makeText(mContext,
                    res.getString(R.string.server_unavailable),
                    Toast.LENGTH_LONG);

            toastMessage.show();
        }

        this.mTellJokeButton.setEnabled(true);
    }
}
