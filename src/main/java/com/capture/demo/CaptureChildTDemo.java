package com.capture.demo;

public class CaptureChildTDemo implements CaptureDemo {
    @Override
    public boolean enabled(long userId) {
        if (userId == CaptureDemo.USER_ID) {
            return true;
        } else {
            return false;
        }
    }
}
