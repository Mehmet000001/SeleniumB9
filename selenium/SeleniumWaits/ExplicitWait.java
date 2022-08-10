package selenium.SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    @Test
    public  void  validateWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.tagName("button"));
        startButton.click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement hello= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));
        System.out.println(hello.getText());
        Assert.assertEquals(hello.getText(),"Hello World!");
    }
    @Test
    public  void  validateImpWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.tagName("button"));
        startButton.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

        //Task : put the condition to wait unit the loading part invisible then get the text from hello element.
        WebElement hello=driver.findElement(By.id("finish"));
        Assert.assertEquals(hello.getText(),"Hello World!");

    }

}
