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
    @BeforeMethod
    public void treadown(){
        driver.quit();
    }
    @Test
    public void checkBox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        String Actualmsg;
        driver.findElement(By.xpath("//input[text()='Click on check box']")).click();
                //driver.findElement(By.xpath("//p[@label="color: green; margin-top: 10px;"]")).getText();
          Actualmsg =  driver.findElement(By.name("checked!")).getText();
        Assert.assertTrue(Actualmsg.contains("checked!"),"\n msg does not contain checked\n");


    }
    @Test
    public void radio(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value ='Other']")).click();
        driver.findElement(By.xpath("//input[@value ='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
        String actualGender = driver.findElement(By.cssSelector(".genderbutton")).getText();
        String actualAge = driver.findElement(By.cssSelector(".groupradiobutton")).getText();
        Assert.assertEquals(actualGender,"male ","\n not correct gender");
        Assert.assertTrue(actualAge.contains("10"),"\n not correct out of range");

    }
}
