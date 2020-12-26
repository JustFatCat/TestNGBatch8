package com.syntax.class02;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW {
    /*Open chrome browser
    Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Login into the application
    Click on Add Employee
    Verify labels: Full Name, Employee Id, Photograph are displayed
    Provide Employee First and Last Name
    Add a picture to the profile
    Verify Employee has been added successfully
    Close the browser*/
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void navigateAndOpen() {
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
    public void addEmployee() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        Thread.sleep(2000);
        WebElement fullName = driver.findElement(By.xpath("//label[@class = 'hasTopFieldHelp']"));
        Thread.sleep(2000);
        System.out.println(fullName.isDisplayed());


    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }


}
