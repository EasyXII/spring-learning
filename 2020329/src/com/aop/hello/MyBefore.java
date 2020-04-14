package com.aop.hello;
//切面类，前置增强
public class MyBefore {
    public void beforeMethod() {
    	System.out.println("This is a before method...");
    }
}
