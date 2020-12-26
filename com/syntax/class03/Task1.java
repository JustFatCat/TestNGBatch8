package com.syntax.class03;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Task1 {
    /*TC 1: HRMS Add Employee:
    Open chrome browser
    Go to HRMS
    Login into the application
    Add 5 different Employees and create login credentials by providing:
    First Name
    Last Name
    Username
            Password
    Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
    Close the browser
    Specify group for this test case, add it into specific suite and execute from xml file.*/
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

    @DataProvider
    public void Object[][] loginData(){
        Object[][] data = new Object[5][2];
        data[0][0] = "Admin";
        data[0][1] = "Human@hrm123";


    }


}
