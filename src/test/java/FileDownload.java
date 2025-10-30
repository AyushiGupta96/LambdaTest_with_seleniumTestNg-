import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FileDownload {
    WebDriver driver;
    @Parameters({"URL"})
    @BeforeMethod
    public void setup(String url){
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        //load the AUT
        driver.get(url);

    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    @Parameters({"task","test result"})
    public void File(String Task,String TestResult){
        //click the file download link
       driver.findElement(By.linkText("File Download")).click();

        // enter data
driver.findElement(By.id("textbox")).sendKeys(Task +"execution"+TestResult);

        //click the generator file button
driver.findElement(By.xpath("//button[@id=\"create\"]")).click();

        //click the download link
        driver.findElement(By.id("link-to-download")).click();
    }
}
