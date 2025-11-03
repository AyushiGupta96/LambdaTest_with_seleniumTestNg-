import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jQuery {
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
    public void jQueryDataPicker(){
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");
        System.out.println(Thread.currentThread().getId()+"jquery data picker page");
    }
    @Test
    public void dataListFilter(){
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
        System.out.println(Thread.currentThread().getId()+" data list filter page");
    }
}
