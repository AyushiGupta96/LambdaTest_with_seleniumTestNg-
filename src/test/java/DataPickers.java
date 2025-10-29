import org.testng.annotations.*;
@Test(groups = "smoke")
public class DataPickers {
    @Test
    public void datePicker(){
    System.out.println("date picker");
}
@Test(groups = {"regression","e2e"})
public void jqueryPicker(){
    System.out.println("jquery date picker");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before ");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method ");
    }
    @BeforeGroups(groups = {"regression","smoke"})
    public void beforeGroup(){
    System.out.println("agter group");
    }
}
