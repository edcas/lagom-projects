package com.lightbend.helloworld;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static org.junit.Assert.assertEquals;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;

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

    @Test
    public void helloWorldTestKit_shouldReturnTheExpectedResult() throws Exception {
        withServer(defaultSetup(), server -> {
            HelloWorldService helloWorldService = server.client(HelloWorldService.class);

            String result = helloWorldService
                    .helloWorld()
                    .invoke()
                    .toCompletableFuture()
                    .get(5, TimeUnit.MINUTES);

            assertEquals("Hello World", result);
        });
    }
}