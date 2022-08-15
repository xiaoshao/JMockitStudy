package com.mockup.demo;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

public class FunTest {
    @Test
    public void test_method() {
        new MockUp<Fun>(Fun.class) {
            @Mock
            public String staticFunc(int x) {
                return "mock static";
            }

            @Mock
            public String publicFunc(int x) {
                return "mock public ";
            }

            @Mock
            public String finalFunc(int x) {
                return "mock final";
            }

            @Mock
            private String privateFunc(int x) {
                return "mock private";
            }
        };

        Fun fun = new Fun();
        System.out.println(Fun.staticFunc(1));
    }
}