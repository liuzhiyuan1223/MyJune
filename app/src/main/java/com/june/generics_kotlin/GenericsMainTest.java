package com.june.generics_kotlin;

public class GenericsMainTest {

    private static final String TAG = "GenericsMainTest";

    //要想使用泛型参数T，需要在前边尖括号声明一下
    public <T> void runTest(T t) {
        GenericsTestJava genField = new GenericsTestJava<String>();
        genField.t = "";
        String result = (String) genField.getResult();
    }
}
