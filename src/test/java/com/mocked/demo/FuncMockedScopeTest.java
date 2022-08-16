package com.mocked.demo;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(JMockit.class)
public class FuncMockedScopeTest {

    @Test
    public void should_mock_all_instances_methods(@Mocked FunMocked funMocked) {
        FunMocked funMocked1 = new FunMocked();

        assertNull(funMocked.sayHello());
        assertNull(funMocked.sayPri());

        assertNull(funMocked1.sayHello());
        assertNull(funMocked1.sayPri());
    }

    @Test
    public void should_mock_all_instances_methods_with_expectation(@Mocked FunMocked funMocked) {

        new Expectations(){{
           funMocked.sayHello();
           result="say hello mock";
        }};

        FunMocked funMocked1 = new FunMocked();

        assertThat(funMocked.sayHello(), is("say hello mock"));
        assertNull(funMocked.sayPri());

        assertThat(funMocked1.sayHello(), is("say hello mock"));
        assertNull(funMocked1.sayPri());
    }

    @Test
    public void should_mock_all_instances_partition_methods(@Mocked FunMocked funMocked) {
        new Expectations(FunMocked.class){{
            funMocked.sayHello();
            result="say hello mock";
        }};

        FunMocked funMocked1 = new FunMocked();

        assertThat(funMocked.sayHello(), is("say hello mock"));
        assertThat(funMocked.sayPri(), is("say private"));

        assertThat(funMocked1.sayHello(), is("say hello mock"));
        assertThat(funMocked1.sayPri(), is("say private"));
    }

    @Test
    public void should_mock_the_specific_instance_partition_methods(@Mocked FunMocked funMocked) {

        new Expectations(funMocked){{
            funMocked.sayHello();
            result="say hello mock";
        }};

        FunMocked funMocked1 = new FunMocked();

        assertThat(funMocked.sayHello(), is("say hello mock"));
        assertThat(funMocked.sayPri(), is("say private"));

        assertThat(funMocked1.sayHello(), is("origin say hello"));
        assertThat(funMocked1.sayPri(), is("say private"));
    }
}
