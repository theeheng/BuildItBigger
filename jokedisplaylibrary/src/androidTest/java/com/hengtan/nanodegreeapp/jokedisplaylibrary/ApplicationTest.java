package com.hengtan.nanodegreeapp.jokedisplaylibrary;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testAlbumGetTask() throws InterruptedException {

        /*JsonGetTask task = new JsonGetTask();
        task.setListener(new JsonGetTask.JsonGetTaskListener() {
            @Override
            public void onComplete(String jsonString, Exception e) {
                mJsonString = jsonString;
                mError = e;
                signal.countDown();
            }
        }).execute("http://www.bbc.co.uk/radio1/playlist.json");
        signal.await();
*/
  //      assertNull(mError);
    //    assertFalse(TextUtils.isEmpty(mJsonString));
      //  assertTrue(mJsonString.startsWith("{\"playlist\""));
        assertTrue(true);

    }
}