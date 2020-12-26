package com.syntax.class01;

import org.testng.annotations.*;

public class PreAndPostConditionAnnotation {
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("I'm before class annotation");
    }
    @Test(alwaysRun = true)
    public void testMethod(){
        System.out.println("I'm a test method");
    }
    @Test(alwaysRun = true)
    public void testMethod2(){
        System.out.println("I'm second test method");
    }
    @Test(alwaysRun = true)
    public void testMethod3(){
        System.out.println("I'm a third method");
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.out.println("I'm before method");
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("I'm after method");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("I'm after class method");
    }

}
