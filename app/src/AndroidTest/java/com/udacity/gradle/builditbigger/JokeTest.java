package com.udacity.gradle.builditbigger;

import android.test.suitebuilder.annotation.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class JokeTest {

    @Test
    public void testJokeEndpointResponse() {

        String result = new JokeUtility().getJoke("jokeendpoint.appspot.com");
        assertTrue(result != null && (!result.isEmpty()));

    }
}


