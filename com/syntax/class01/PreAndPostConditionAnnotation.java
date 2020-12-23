package com.syntax.class01;

import org.testng.annotations.*;

public class PreAndPostConditionAnnotation {
    @BeforeClass
    public void beforeClass(){
        System.out.println("I'm before class annotation");
    }
    @Test
    public void testMethod(){
        System.out.println("I'm a test method");
    }
    @Test
    public void testMethod2(){
        System.out.println("I'm second test method");
    }
    @Test
    public void testMethod3(){
        System.out.println("I'm a third method");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I'm before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I'm after method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I'm after class method");
    }

}
