package selenium.test.sentrifugo.tests;

import selenium.Utils.BrowserUtils;
import selenium.test.sentrifugo.page.DepartmentPage;
import selenium.test.sentrifugo.page.HomePage;
import selenium.test.sentrifugo.page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DepartmentTest {
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    HomePage homePage;
    DepartmentPage departmentPage;
    @BeforeMethod
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        softAssert=new SoftAssert();
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        departmentPage=new DepartmentPage(driver);
    }
    @Test
    public  void validateAddDepartment() throws InterruptedException {
        loginPage.login("EM01","sentrifugo");
        Thread.sleep(600);
        homePage.clickDepartment();
        Thread.sleep(600);
        departmentPage.clickAddButton();
        Thread.sleep(600);
        BrowserUtils.scrollIntoView(driver,departmentPage.getSaveButton());
        departmentPage.sendDepartmentDescription("Finance","123","Techtorial Test");
        Thread.sleep(600);
        String actualMessage=departmentPage.getSuccessMessage();
        String expectedMessage="Department added successfully.";
        Assert.assertEquals(actualMessage,expectedMessage,"New Department Validation");

    }
}
