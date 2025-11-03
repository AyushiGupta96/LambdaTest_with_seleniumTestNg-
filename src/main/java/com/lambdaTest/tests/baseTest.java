package com.lambdaTest.tests;

import com.lamdaTest.pages.basePage;
import com.lamdaTest.pages.homePage;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class baseTest {
    private WebDriver driver;
    private homePage home;
    private basePage base;
    private final String AUT_URL = "https://www.lambdatest.com/selenium-playground/";
    @BeforeClass
    public void setUp(){
        WebDriverManager.EdgeDriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    @BeforeMethod
    public  void loadApplication(){
        driver.get(AUT_URL);
        base = new basePage();
        base.setDriver(driver);
        home = new homePage();
    }
    @AfterMethod
    public void screenShotOfFailed(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot s = (TakesScreenshot) driver;
            File source = s.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshot/Simpleform_pass.png" +
                    testResult.getName() + ".png");
            try {
                org.openqa.selenium.io.FileHandler.copy(source, destination);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }



}
