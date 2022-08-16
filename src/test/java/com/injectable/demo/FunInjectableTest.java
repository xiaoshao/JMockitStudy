package com.injectable.demo;

import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

@RunWith(JMockit.class)
public class FunInjectableTest {

    @Test
    public void should_mock_specified_instances_and_partition_methods(@Injectable FunInjectable funInjectable) {
        assertNull(funInjectable.sayHelloPub(10));
        assertNull(funInjectable.invokePrivate(10));
        assertThat(FunInjectable.sayHelloStatic(10), is("say hello static 10"));
    }

    @Test
    public void should_mock_specified_instances_and_partition_methods1(@Injectable FunInjectable funInjectable) {
        new Expectations(){{
            funInjectable.sayHelloPub(anyInt);
            result = "say hello in mock";
        }};

        assertThat(funInjectable.sayHelloPub(10), is("say hello in mock"));
        assertNull(funInjectable.invokePrivate(10));
        assertThat(FunInjectable.sayHelloStatic(10), is("say hello static 10"));

        FunInjectable funInjectable1 = new FunInjectable();

        assertThat(funInjectable1.sayHelloPub(10), is("say hello pub 10"));
        assertThat(funInjectable1.invokePrivate(10), is("say hello private 10  is called"));
    }
}