package com.mockup.demo;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        assertThat(Fun.staticFunc(1), is("mock static"));
        assertThat(fun.callPrivateFunc(10), is("mock private is called"));
        assertThat(fun.finalFunc(10), is("mock final"));
        assertThat(fun.publicFunc(10), is("mock public "));
    }

    @Test
    public void test_method2() {
        Fun fun = new Fun();
        assertThat(Fun.staticFunc(1), is("mock static"));
        assertThat(fun.callPrivateFunc(10), is("mock private is called"));
        assertThat(fun.finalFunc(10), is("mock final"));
        assertThat(fun.publicFunc(10), is("mock public "));
    }
}