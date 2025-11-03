import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AjaxForm {
    WebDriver driver;

    //@Parameters({"URL"})
    @BeforeMethod
    public void setup(String url) {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        //load the AUT
        driver.get("https://www.lambdatest.com/selenium-playground/");

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider
    public Object[][] AjaxFormData() {
        //driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        Object[][] data = new Object[2][2];
        data[0][0] = " a a";
        data[0][1] = "b b";
        data[1][0] = " a a";
        data[1][1] = " b b";
        return data;
    }

    @Test(dataProvider = "AjaxFormData")
    public void AjaxFormSubmit(String name, String comment) {
        System.out.println("name" + name);
        System.out.println("comment" + comment);
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(name);
        driver.findElement(By.id("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();
    }
    @Test(dataProviderClass = DataProvider.class,dataProvider = "input provider")
    public void inputForm(String name,String email,int inputNumber){
        System.out.println("inputNumber"+inputNumber);
        System.out.println("name"+name);
        System.out.println("email"+email);

        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("inputEmail4")).sendKeys();



    }

    }

