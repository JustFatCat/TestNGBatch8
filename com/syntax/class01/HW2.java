package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW2 {
    /*US 17666 Syntax Logo should be present on the login page
    US 17667 Error message “Invalid credentials” should be displayed when user enters invalid credentials*/
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--no-sandbox"); // Bypass OS security model

        driver = new ChromeDriver(options);
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups = "regression", alwaysRun = true)
    public void checkingLogo(){
        WebElement syntaxLogo = driver.findElement(By.xpath("//img[contains(@src, 'humanresources')]"));
        /*if(syntaxLogo.isDisplayed()){
            System.out.println("Logo is displayed. Test passed");
        }else {
            System.out.println("Logo is not displayed. Test failed");
        }*/
        Assert.assertTrue(syntaxLogo.isDisplayed(), "Logo is not displayed");
    }
    @Test(groups = "regression", alwaysRun = true)
    public void checkingErrorMess(){
        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("Invalid");
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("Invalid");
        driver.findElement(By.id("btnLogin")).click();
        String invalidMessage = driver.findElement(By.id("spanMessage")).getText();
        String expectedErrorMessage = "Invalid credentials";
        /*if (invalidMessage.equals(expectedErrorMessage)){
            System.out.println("Message is displayed. Test passed");
        }else {
            System.out.println("Message is not displayed. Test failed");
        }*/
        System.out.println("My code before the assertion");
        Assert.assertEquals(invalidMessage, expectedErrorMessage, "Not correct error message is displayed");
        System.out.println("My code after the assertion");
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
