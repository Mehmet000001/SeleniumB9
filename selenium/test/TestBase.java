package selenium.test;

import selenium.Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    //if you are repeating same code under the different test classes
    //we can put them inside the testbase class and extend test class
    //with testbase class
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }
    @AfterMethod
    public  void tearDown(){
        Driver.tearDown();


    }
}
