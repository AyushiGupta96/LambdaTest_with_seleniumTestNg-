import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import static java.util.logging.FileHandler.*;

public class Form {
    WebDriver driver;
    //@Parameters({"URL"})
    @BeforeMethod
    public void setup(String url){
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        //load the AUT
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void form(){
        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input")).sendKeys("lamba");
        driver.findElement(By.id("showInput")).click();
        String actMsg= driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actMsg,"lamba","wrong");
    }
    @AfterMethod
    public void TakeScreenShotForFailure(ITestResult testResult){
        if(ITestResult.FAILURE==testResult.getStatus()) {
            TakesScreenshot s = (TakesScreenshot) driver;
            File source = s.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshot/Simpleform_pass.png" +
            testResult.getName()+".png");
            try {
                org.openqa.selenium.io.FileHandler.copy(source, destination);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
}
}
