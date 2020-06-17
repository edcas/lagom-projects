package com.lightbend.helloworld;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HelloWorldServiceImplTest {

    @Test
    public void helloWorld_shouldReturnTheExpectedResult() throws Exception {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();

        String result = helloWorldService
                .helloWorld()
                .invoke()
                .toCompletableFuture()
                .get(5, TimeUnit.MINUTES);

        assertEquals("Hello World", result);
    }
}