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
    private String mEndPointServer;
    private Resources mResources;

    public JokeEndpointsAsyncTask(Context ctxt, IJokeUtility ju, View btn, FrameLayout progressBarHolder)
    {
        this.mContext = ctxt;
        this.mJokeUtility = ju;
        this.mTellJokeButton = btn;
        this.mProgressBarHolder = progressBarHolder;
        this.mResources = mContext.getResources();
        this.mEndPointServer = mResources.getString(R.string.joke_end_point_server);
    }

    public JokeEndpointsAsyncTask(Context ctxt, IJokeUtility ju, View btn, FrameLayout progressBarHolder, String endPointServer)
    {
        this.mContext = ctxt;
        this.mJokeUtility = ju;
        this.mTellJokeButton = btn;
        this.mProgressBarHolder = progressBarHolder;
        this.mEndPointServer = endPointServer;
    }

    @Override
    protected String doInBackground(Void... params) {

        if(mProgressBarHolder != null) {
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ProgressBarHelper.ShowProgressBar(mProgressBarHolder);
                }
            });
        }


        return mJokeUtility.getJoke(mEndPointServer, AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory());
    }

    @Override
    protected void onPostExecute(String result) {

        if(mProgressBarHolder != null) {
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ProgressBarHelper.HideProgressBar(mProgressBarHolder);
                }
            });
        }

        if(result != null) {
            mJokeUtility.DisplayJoke(mContext, result);
        }
        else
        {
            Toast toastMessage = Toast.makeText(mContext,
                    mResources.getString(R.string.server_unavailable),
                    Toast.LENGTH_LONG);

            toastMessage.show();
        }

        if(mTellJokeButton != null) {
            this.mTellJokeButton.setEnabled(true);
        }
    }
}
