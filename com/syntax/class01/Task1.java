package com.syntax.class01;

import org.testng.annotations.Test;
/*Task 1: Executing tests using @Test
Create three tests with unique @test methods names.
Execute all test methods*/
public class Task1 {
    @Test(alwaysRun = true)
    public void printName(){
        System.out.println("Sofia");
    }
    @Test(alwaysRun = true)
    public void printLastName(){
        System.out.println("Mint");
    }
    @Test(alwaysRun = true)
    public void sayMya(){
        System.out.println("Mya");
    }
}
