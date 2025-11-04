import io.cucumber.java.ja.但し;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;

public class capabilities_generator {
    WebDriver driver;
    private  String username="ayushigupta4050";
    private String accessKey = "LT_LKcu24JFf3ef8WATvOOB0R9XEJcLAjNhcsAlyCQukCWrr4f";
    private String hub = "https://ayushigupta4050:LT_LKcu24JFf3ef8WATvOOB0R9XEJcLAjNhcsAlyCQukCWrr4f@hub.lambdatest.com/wd/hub";
    DesiredCapabilities cap = new DesiredCapabilities();
    @Parameters(value = {"browser","version","platform"})
    @BeforeMethod
    public void setup(String Browser, String version,String Platform){
        cap.setCapability("build","2.1");
        cap.setCapability("name","cross browser test");
        cap.setCapability("browser name","Browser");
        cap.setCapability("version","version");
        cap.setCapability("platform","Platform");
        cap.setCapability("network",true);
        cap.setCapability("console",true);//recalls logs
        cap.setCapability("visual",true);//screenshot of every test step
        try {
            driver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+hub),cap);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
       //
        // driver.get("https://www.lambdatest.com/capabilities-generator/");
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @Test
    public  void DropDown(){
        driver.findElement(By.linkText("Select Dropdown List")).click();
        WebElement find = driver.findElement(By.id("select-demo"));
        Select day = new Select(find);
        day.selectByVisibleText("Saturday");
    }
    @Test
    public void dragAndDrop(){
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement source=driver.findElement(By.id("todrag"));
        WebElement target =driver.findElement(By.id("mydropzone"));
        Actions a = new Actions(driver) ;
        a.dragAndDrop(source,target).perform();
    }
}
