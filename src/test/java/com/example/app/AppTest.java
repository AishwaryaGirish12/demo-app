package com.example.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testGreet() {
        String result = App.greet("DevOps Student");
        assertEquals("Hello, DevOps Student! DevOps Pipeline is Running Successfully.", result);
    }

    @Test
    public void testGreetWithDifferentName() {
        String result = App.greet("ABA");
        assertEquals("Hello, ABA! DevOps Pipeline is Running Successfully.", result);
    }

    @Test
    public void testGetVersion() {
        String version = App.getVersion();
        assertEquals("v1.0", version);
    }
}
