package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

import org.junit.runner.RunWith;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class JokeTest {

    private static final String mJokeEndPointServer = "10.0.2.2:8080";

    @Test
    public void testJokeUtilityGetJoke() {

        String result = new JokeUtility().getJoke(mJokeEndPointServer, AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory());
        assertTrue(result != null && (!result.isEmpty()));

    }
}


