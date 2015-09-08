package com.udacity.gradle.builditbigger;
import android.content.Context;
import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class JokeTest {

    @Test
    public void testJokeEndpointResponse() {

        String result = new JokeUtility().getJoke("jokeendpoint.appspot.com");
        assert (result!=null && (!result.isEmpty()));

    }
}

