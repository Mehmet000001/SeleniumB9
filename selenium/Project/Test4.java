package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4 {
    @Test
    public void testcase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement singleCheckbox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        singleCheckbox.click();
        WebElement validate=driver.findElement(By.xpath("//div[@id='txtAge']"));
        String actual=validate.getText();
        String expect="Success - Check box is checked";
        Assert.assertEquals(actual,expect);




    }
}
