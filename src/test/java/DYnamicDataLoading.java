import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.function.Function;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class DYnamicDataLoading {
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
    public void dataLoad(){
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.id("save")).click();
        By image = By.xpath("//div[@id=\"loading\"]//img");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
        boolean isImage = driver.findElement(image).isDisplayed();
        Assert.assertTrue(isImage,"\n image is not displayed \n");
    }
    @Test
    public void jqueryDownload(){
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30L))
        .pollingEvery(Duration.ofMillis(100))
        .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement progess = driver.findElement(By.xpath("//div[@id='dialog']//div[@class='progress-label']"));
                String progressBarText = progess.getText();
                if(progressBarText.equals("Complete!")){
                    System.out.println("download completed");
                    return progess;

                }
                else {
                    System.out.println(progess.getText());
                    return null;
                }
            }
        });


    }
}
