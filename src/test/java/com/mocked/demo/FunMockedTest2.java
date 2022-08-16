package com.mocked.demo;

import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JMockit.class)
public class FunMockedTest2 {

    @Test
    public void should_mocked_the_method(@Mocked FunMocked funMocked) {
        new Expectations(){{
            funMocked.sayHello();
            result = "mocked say hello";
        }};

        String result = funMocked.sayHello();

        assertThat(result, is("mocked say hello"));
    }

    @Test
    public void should_no_mocked() {
        FunMocked funMocked = new FunMocked();

        String result = funMocked.sayHello();

        assertThat(result, is("origin say hello"));
    }
}
