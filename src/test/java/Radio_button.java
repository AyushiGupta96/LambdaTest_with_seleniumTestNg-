import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_button {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @Test
    public void checkBox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        String Actualmsg;
        driver.findElement(By.xpath(//input[text()="Click on check box"])).click();
                //driver.findElement(By.xpath("//p[@label="color: green; margin-top: 10px;"]")).getText();
          Actualmsg =  driver.findElement(By.name("checked!")).getText();
        Assert.assertTrue(Actualmsg.contains("checked!"),"\n msg does not contain checked\n");


    }
}
