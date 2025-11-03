import org.testng.annotations.DataProvider;

public class inputFormData {
    @DataProvider(name = "input provider")
    public Object[][] inputData() {
        //driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        Object[][] data = new Object[2][3];
        data[0][0] = " a a"; data[0][1] = "a@gmail.com"; data[0][2]=1;
        data[1][0] = " b b";data[1][1] = " b@gmail.com"; data[1][2]=2;
        return data;
    }
}
