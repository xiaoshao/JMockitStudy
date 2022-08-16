package com.mocked.demo;

import com.mockup.demo.Fun;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JMockit.class)
public class FunMockedTest {

    @Mocked
    FunMocked funMocked;

    @Test
    public void test_mocked() {
       new Expectations(){
           {
               funMocked.sayHello();
               result = "mocked say hello 1";
           }
       };

        String result = funMocked.sayHello();

        assertThat(result, is("mocked say hello 1"));

        new Verifications(){{
            funMocked.sayHello();
            times = 1;
        }};
    }

    @Test
    public void test_mocked_in_p(@Mocked FunMocked funMocked) {
        new Expectations(){{
           funMocked.sayHello();
           result = "say hello parameter";
        }};

        String result = funMocked.sayHello();

        assertThat(result, is("say hello parameter"));

        new Verifications(){{
           funMocked.sayHello();
           times = 1;
        }};
    }
}