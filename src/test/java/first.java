import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class first {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
       WebDriverManager.edgedriver.setup();
       // WebDriver.edge.driver.setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        //System.out.println();
    }
    @BeforeMethod
    public void treadown(){
        driver.quit();
    }
    @Test(priority = -1)
    public void TableSortAndsearch(){
        driver.findElement(By.linkText("Table Sort & Search")).click();
        driver.findElement(By.xpath("//div[@id=\"example_filter\"]//input[@type=\"search\"]")).sendKeys("A.");
    }
    @Test
    public void Bootstrap_Datepicker(){
        driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.id("birthday")).sendKeys("13/06/1996");
    }
}
