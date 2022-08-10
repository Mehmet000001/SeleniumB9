package selenium.SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitsWaits {
    @Test
    public void validateWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //10 webelement.
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("https://www.google.com/search?q=selenium+hq&newwindow=1&sxsrf=AOaemvKWonZqAdOhZW45I2[…]t=gws-wiz&ved=0ahUKEwi118ii-NPyAhUJHs0KHWnOAAoQ4dUDCAo&uact=5");
        List<WebElement>buttons=driver.findElements(By.xpath("//div[contains(@class,'hdtb')]//a"));
        for (WebElement button:buttons){
            System.out.println(button.getText());
        }
    }
}
