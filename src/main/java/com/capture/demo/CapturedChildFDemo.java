package com.capture.demo;

public class CapturedChildFDemo implements CaptureDemo {
    @Override
    public boolean enabled(long userId) {
        if (userId == CaptureDemo.USER_ID) {
            return false;
        } else {
            return true;
        }
    }
}
