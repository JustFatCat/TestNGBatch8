package com.syntax.class01;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HW1 {
    /*Task 1: Executing different test based TestNG annotations
    Create class that will have:
    Before and After Class annotation
    Before and After Method annotation
    2 methods with Test annotation*/
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("I'm beforeClass method");
    }
    @Test(alwaysRun = true)
    public void test1(){
        System.out.println("I'm first method");
    }
    @Test(alwaysRun = true)
    public void test2(){
        System.out.println("I'm second method");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("I'm afterClass method");
    }
}
