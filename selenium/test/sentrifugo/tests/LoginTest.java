package selenium.test.sentrifugo.tests;

import selenium.Utils.BrowserUtils;
import selenium.test.sentrifugo.data.CredData;
import selenium.test.sentrifugo.page.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage = new LoginPage(driver);
        //if you do not initialize the LoginPage object you can not use the webelement.
    }
    //Task:provide correct username and passwords from dataprovider annotatin.

    @Test(dataProvider = "positiveCred",dataProviderClass =CredData.class)
    public void validateLoginPositive(String username1,String password1) {
        loginPage.login(username1,password1);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualUrl, expectedUrl);

    }
    @AfterMethod
    public void tearDown(ITestResult result){
        //result.getTestName()--->returns the methodName from test annotation.
        if (!result.isSuccess()){
            BrowserUtils.getScreenShot(driver,"sentrifugo");
            }
driver.quit();

    }

//    @Test
//    public void validateLoginManagement() {
//        loginPage.login("EM02", "sentrifugo");
//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
//        Assert.assertEquals(actualUrl, expectedUrl);
//
//    }

    //create one more test annotation
    //provide invalid username but corret password
    //validate "The
    //TASK:using data provider
//    @DataProvider(name="credentials")
//    public Object[][] getGred(){
//        return new Object[][]{
//                {"Mehmet","sentrifugo"},
//                {"EM01","test"},
//                {"test","test"}
//
//        };
//    }
    @Test(dataProvider = "credentials",dataProviderClass = CredData.class)
    public void validateNegativeLogin1(String username,String password) throws InterruptedException {
        loginPage.login(username,password);
        Thread.sleep(500);
        String actualErrMessage = loginPage.getErrorText();//it comes from the website
        String expectedMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrMessage, expectedMessage);

    }
//    @Test
//    public void validateNegativeLogin2() throws InterruptedException {
//        loginPage.login("EM01","test");
//        Thread.sleep(500);
//        String actualErrMessage = loginPage.getErrorText();//it comes from the website
//        String expectedMessage = "The username or password you entered is incorrect.";
//        Assert.assertEquals(actualErrMessage, expectedMessage);
//    }
//    @Test
//    public void validateNegativeLogin3()throws InterruptedException {
//        loginPage.login("test","test");
//        Thread.sleep(500);
//        String actualErrMessage = loginPage.getErrorText();//it comes from the website
//        String expectedMessage = "The username or password you entered is incorrect.";
//        Assert.assertEquals(actualErrMessage, expectedMessage);
}
