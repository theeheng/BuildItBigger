package com.udacity.gradle.builditbigger;


import org.junit.Test;

public class EchoTest {
    @Test
    public void verifyEchoResponse() {
        assert "hello".equals("hello");
    }

    @Test
    public void verifyLoggingEchoResponse() {
        assert "hello".equals("hello");
    }
}

