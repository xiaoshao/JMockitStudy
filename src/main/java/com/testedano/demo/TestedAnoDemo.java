package com.testedano.demo;

public class TestedAnoDemo {

    private TestAttribute testAttribute;

    private TestConstructParams testConstructParams;

    public TestedAnoDemo(TestConstructParams testConstructParams) {
        this.testConstructParams = testConstructParams;
    }

    public String invokeAttribute(){
        return testAttribute.sayHello();
    }

    public String invokeConstructParam(){
        return this.testConstructParams.sayHello();
    }
}
