package com.syntax.class01;

import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(alwaysRun = true)
    public void sayHello(){
        System.out.println("Hello!");
    }
    @Test(alwaysRun = true)
    public void sayBuy(){
        System.out.println("Bye!");
    }
    @Test(alwaysRun = true)
    public void howAreYou(){
        System.out.println("How are you today?");
    }

}
