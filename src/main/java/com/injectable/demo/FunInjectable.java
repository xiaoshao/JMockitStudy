package com.injectable.demo;

public class FunInjectable {
    public String sayHelloPub(int x) {
        return "say hello pub " + x;
    }

    public static String sayHelloStatic(int x) {
        return "say hello static " + x;
    }

    private String sayPrivateHello(int x) {
        return "say hello private " + x;
    }

    public String invokePrivate(int x) {
        return sayPrivateHello(x) + "  is called";
    }
}
