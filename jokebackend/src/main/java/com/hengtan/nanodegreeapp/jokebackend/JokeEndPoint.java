/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.hengtan.nanodegreeapp.jokebackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jokelib.JokeProvider;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "jokebackend.nanodegreeapp.hengtan.com",
                ownerName = "jokebackend.nanodegreeapp.hengtan.com",
                packagePath = ""
        )
)
public class JokeEndPoint {

    /**
     * A simple endpoint method that display random Jokes
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        JokeProvider jokeProvider = new JokeProvider();
        JokeBean jb = new JokeBean();

        jb.setData(jokeProvider.GetJoke());

        return jb;
    }

}
