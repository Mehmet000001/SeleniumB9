package selenium.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindow {
    @Test
    public  void openNewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();//instantiate the chromedriver
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getCurrentUrl());
        JavascriptExecutor js=(JavascriptExecutor) driver;//to create new window
        js.executeScript("window.open('https://www.techtorialacademy.com/apply-now');");
        String mainId=driver.getWindowHandle();
        Set<String>ids=driver.getWindowHandles();
        for (String id:ids){
            if (!id.equals(mainId)){
                driver.switchTo().window(id);
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().endsWith("apply-now"),"Apply now url validation.");//this message when your condition fail you can see it.
        System.out.println(driver.getCurrentUrl());

    }
}
