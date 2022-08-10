package selenium.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork1 {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkallbutton = driver.findElement(By.id("check1"));
        boolean actual=checkallbutton.isDisplayed();
        boolean expected=true;
        Assert.assertEquals(actual,expected);
        String actual1=checkallbutton.getAttribute("value");
        String expected1 = "Check All";
        Assert.assertEquals(actual,expected);
        checkallbutton.click();
        List<WebElement> boxes =  driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for(WebElement checkingboxes:boxes){
            boolean actual2=checkingboxes.isSelected();
            boolean expected2=true;
            Assert.assertEquals(actual,expected);
        }
        WebElement uncheck=driver.findElement(By.id("check1"));
        String actualuncheck=uncheck.getAttribute("value");
        String expectedunchecked="Uncheck All";
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void testcase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkall = driver.findElement(By.id("check1"));
        boolean actualcheck = checkall.isDisplayed();
        boolean expectedcheck = true;
        Assert.assertEquals(actualcheck, expectedcheck);
        String actualcheck1 = checkall.getAttribute("value");
        String expectedcheck1 = "Check All";
        Assert.assertEquals(actualcheck1, expectedcheck1);
        List<WebElement> boxs = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement singlebox : boxs) {
            boolean actualisnotselected = singlebox.isSelected();
            //  boolean expectedisnotselected=false;

            Assert.assertFalse(actualisnotselected);
            Thread.sleep(2000);
            singlebox.click();
        }
        WebElement uncheck = driver.findElement(By.id("check1"));
        String actualuncheckname = uncheck.getAttribute("value");
        String expecteduncheckname = "Uncheck All";
        Assert.assertEquals(actualuncheckname, expecteduncheckname);


    }
    }