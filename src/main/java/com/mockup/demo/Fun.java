package com.mockup.demo;

public class Fun {
    public static String staticFunc(int x) {
        return "this is static function " + x;
    }

    public String publicFunc(int x) {
        return "this is public function " + x;
    }

    public final String finalFunc(int x) {
        return "this is final function " + x;
    }

    private String privateFunc(int x) {
        return "this is private function " + x;
    }

    public String callPrivateFunc(int x) {
        return privateFunc(x) + " is called";
    }
}
