package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test8 {
    @Test
    public  void testcase8(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://blazedemo.com/purchase.php");
        WebElement firstName=driver.findElement(By.xpath("//input[@id='inputName']"));
        firstName.sendKeys("David");
    }
}
