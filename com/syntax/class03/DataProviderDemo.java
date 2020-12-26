package com.syntax.class03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {
    //public --> protected --> default --> private
    @DataProvider
    public Object [][] loginData(){
        Object loginData[][] = new Object[3][2];
        loginData[0][0] = "Admin";
        loginData[0][1] = "Human@hrm123";
        loginData[1][0] = "James";
        loginData[1][1] = "12345";
        loginData[2][0] = "Burju";
        loginData[2][1] = "Syntax123";

        return loginData;
    }
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

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
