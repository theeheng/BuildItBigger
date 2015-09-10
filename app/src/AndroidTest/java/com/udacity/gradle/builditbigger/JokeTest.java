package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import org.junit.runner.RunWith;
import org.junit.Test;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class JokeTest extends ApplicationTestCase<Application> {

    public JokeTest() {
        super(Application.class);
    }

    @Test
    public void testJokeUtilityGetJoke() {

        String result = new JokeUtility().getJoke("jokeendpoint.appspot.com", AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory());
        assertTrue(result != null && (!result.isEmpty()));

    }

    @Test
    public void testJokeEndpointAsyncTask() {

        Context context = getApplication();
        View tellJokeButton = new View(context);
        FrameLayout progressBarHolder = new FrameLayout(context);

        new JokeEndpointsAsyncTask(context, new JokeUtilityTest() , tellJokeButton, progressBarHolder).execute();

        assertTrue(true);

    }
}

class JokeUtilityTest extends JokeUtility {
    @Override
    public void DisplayJoke(Context context, String joke)
    {

    }
}


