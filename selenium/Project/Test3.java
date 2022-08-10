package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 {
    @Test
    public  void testcase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        WebElement xbutton=driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']"));
        Thread.sleep(3000);
        xbutton.click();
        WebElement enterA=driver.findElement(By.xpath("//input[@id='sum1']"));
        enterA.sendKeys("Chicago");
        WebElement enterB=driver.findElement(By.xpath("//input[@id='sum2']"));
        enterB.sendKeys("Illinois");
        WebElement getTotal=driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
        getTotal.click();
        WebElement validate=driver.findElement(By.xpath("//div[@style='height: 50px; width: 100%;']"));
        String actual=validate.getText();
        String expected="Total a + b = NaN";
        Assert.assertEquals(actual,expected);

    }
}
