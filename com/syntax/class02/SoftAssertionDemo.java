package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionDemo {
    //As an admin I should be able to login into HRMS
        //logo is Displayed
        //user is successfully logged in
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void navigateAndOpen(){
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
    public void logoAndValidLogin(){
        //verifying that logo is displayed
        WebElement syntaxLogo = driver.findElement(By.xpath("//img[contains(@src, 'humanresources')]"));
        //creating an object of SoftAssertion class
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(syntaxLogo.isDisplayed(), "Logo is not displayed");

        //entering valid credentials to login
        String userName = "Admin";
        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        //validating that we are logged in
        WebElement welcome = driver.findElement(By.linkText("Welcome Admin"));
        softAssert.assertTrue(welcome.isDisplayed(), "Welcome message is not displayed");
        softAssert.assertEquals(welcome.getText(), "Welcome " + userName, "Welcome test is not matching");
        System.out.println("End of the test");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
