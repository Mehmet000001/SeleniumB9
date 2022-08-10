package selenium.Homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
    WebDriver driver;
    @BeforeMethod
    public  void  setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.openemr.io/openemr");
        driver.manage().window().maximize();

    }
    @Test
    public  void testcase1() throws InterruptedException {
        WebElement userName=driver.findElement(By.xpath("//input[@id='authUser']"));
        userName.sendKeys("admin");
        WebElement passWord=driver.findElement(By.xpath("//input[@id='clearPass']"));
        passWord.sendKeys("pass");
        WebElement laug=driver.findElement(By.xpath("//select[@name='languageChoice']"));
        Select select=new Select(laug);
        select.selectByIndex(15);
        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement search=driver.findElement(By.xpath("//input[@id='anySearchBox']"));
        search.sendKeys("Santos"+ Keys.ENTER);
        Thread.sleep(2000);
        driver.switchTo().frame("fin");
        WebElement name=driver.findElement(By.linkText("Anderson, Santos"));
        String actual=name.getText();
        String expected="Anderson, Santos";
        Assert.assertEquals(actual,expected);
        WebElement ssn=driver.findElement(By.xpath("//td[contains(text(),'088899889')]"));
        String actualSSN=ssn.getText();
        String expectedSSN="088899889";
        Assert.assertEquals(actualSSN,expectedSSN);
        WebElement externalId=driver.findElement(By.xpath("//td[contains(text(),'12345')]"));
        String actualExternalId=externalId.getText();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Actions actions=new Actions(driver);
        WebElement parents=driver.findElement(By.xpath("//div[contains(text(),'Patient/Client')]"));
        actions.moveToElement(parents).perform();




    }
}
