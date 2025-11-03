import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class bootstrapAlerts {
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
    @Test(threadPoolSize = 3,invocationCount = 4)//4 times it will run

    public void bootstrapAlers(){
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
        System.out.println(Thread.currentThread().getId()+"bootstrap alerts");
    }
    @Test
    public void dragAnddrop(){
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        System.out.println(Thread.currentThread().getId()+" dgra and drop page");
    }
}
