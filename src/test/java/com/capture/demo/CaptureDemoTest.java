package com.capture.demo;

import mockit.Capturing;
import mockit.Expectations;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JMockit.class)
public class CaptureDemoTest {

    @Test
    public void should_affect_child(@Capturing CaptureDemo captureDemo) {

        new Expectations(){{
            captureDemo.enabled(CaptureDemo.USER_ID);
            result = true;
        }};

        assertTrue(new CapturedChildFDemo().enabled(CaptureDemo.USER_ID));
        assertTrue(new CaptureChildTDemo().enabled(CaptureDemo.USER_ID));
    }
}