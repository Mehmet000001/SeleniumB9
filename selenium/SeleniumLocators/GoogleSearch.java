package selenium.SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearch {
    @Test
    public void  validateGoogleSearch(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        WebElement searchbox=driver.findElement(By.name("q"));
        searchbox.sendKeys("selenium"+ Keys.RETURN);
        //Task:print headers from all the results.
        List<WebElement> results=driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
        for (WebElement result:results){
           if (!result.getText().equals("")){
               Assert.assertTrue(result.getText().contains("Selenium"));
           }
        }
    }
}
