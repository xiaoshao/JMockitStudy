package com.testedano.demo;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JMockit.class)
public class TestedAnoDemoTest {

    @Test
    public void should_injected_test_target(@Tested TestedAnoDemo testedAnoDemo, @Injectable TestConstructParams testConstructParams, @Injectable TestAttribute testAttribute) {

        new Expectations(){{
           testConstructParams.sayHello();
           result = "test construct mock";
           testAttribute.sayHello();
           result = "test attribute mock";
        }};

        assertThat(testedAnoDemo.invokeAttribute(), is("test attribute mock"));
        assertThat(testedAnoDemo.invokeConstructParam(), is("test construct mock"));
    }
}