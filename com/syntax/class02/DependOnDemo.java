package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependOnDemo {
    @Test(alwaysRun = true)
    public void login(){
        System.out.println("I am login in");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "login", alwaysRun = true)//if login fails, this Test method will get ignored
    public void addEmployee(){
        System.out.println("I am adding an Employee");
    }
    /*@Test()
    public void test3(){
        System.out.println("I am test 3");
    }*/

}
