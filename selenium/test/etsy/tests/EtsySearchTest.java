package selenium.test.etsy.tests;

import selenium.test.etsy.pages.EtsyHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsySearchTest {
    WebDriver driver;
    EtsyHomePage homePage;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        homePage=new EtsyHomePage(driver);
    }
    @Parameters("searchtext")
    @Test
    public void validateSearch(String text){
        homePage.sendSearchInput("text");
        Assert.assertTrue(homePage.checkItemText());
    }
    @Parameters("searchtext1")
    @Test
    public void validateSearch1(String text){
        homePage.sendSearchInput(text);
    }
    @Parameters("searchtext2")
    @Test
    public void validateSearch2(String text){
        homePage.sendSearchInput(text);
    }
}
