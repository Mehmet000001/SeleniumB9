package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public  void Testcase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        WebElement xbutton=driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']"));
        Thread.sleep(3000);
        xbutton.click();
        String actual=driver.getTitle();
        String expectedtitle="Selenium Easy Demo - Simple Form to Automate using Selenium";
        Assert.assertEquals(actual,expectedtitle);
        WebElement message=driver.findElement(By.xpath("//input[@id='user-message']"));
        message.sendKeys("First Test Case");
        WebElement showmessage=driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        showmessage.click();
        WebElement message1=driver.findElement(By.xpath("//span[@id='display']"));
        String actualMessage=message1.getText();
        String expected="First Test Case";
        Assert.assertEquals(actualMessage,expected);




    }

}
