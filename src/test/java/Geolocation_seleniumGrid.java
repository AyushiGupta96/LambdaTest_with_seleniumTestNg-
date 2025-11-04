import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Geolocation_seleniumGrid {
    WebDriver driver;
    private  String username="ayushigupta4050";
    private String accessKey = "LT_LKcu24JFf3ef8WATvOOB0R9XEJcLAjNhcsAlyCQukCWrr4f";
    private String hub = "https://ayushigupta4050:LT_LKcu24JFf3ef8WATvOOB0R9XEJcLAjNhcsAlyCQukCWrr4f@hub.lambdatest.com/wd/hub";
    DesiredCapabilities cap = new DesiredCapabilities();
    @Parameters(value = {"browser","version","platform"})
    @BeforeMethod
    public void setup(String Browser, String version,String Platform){
        cap.setCapability("build","3.1");
        cap.setCapability("name","geolocation test");
        cap.setCapability("geoLocation","IN");
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
        driver.get("https://where-am-i.org/");
    }
    @Test
    public  void geolocation(){
        WebElement l = driver.findElement(By.id("address"));
        System.out.println("address"+l.getText());
    }
}
