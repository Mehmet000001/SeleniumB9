package selenium.WindowHandle;

import selenium.Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowHandle {
    @Test
    public  void  multipleWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
        WebElement followAll=driver.findElement(By.id("followall"));
        followAll.click();
        String mainWindow=driver.getWindowHandle();
        Set<String>windows=driver.getWindowHandles();
//        for (String window:windows){
//            if (!driver.getTitle().contains("Facebook")){
//                driver.switchTo().window(window);
//
//            }
//        }
        BrowserUtils.switchByTitle(driver,"Facebook");
        BrowserUtils.switchByTitle(driver,"Twitter");
        BrowserUtils.switchByTitle(driver,"Google");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.switchTo().window(mainWindow);
    }
    //create one method that switch the window
    @Test
    public  void  closeAllWindows(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
        WebElement followAll=driver.findElement(By.id("followall"));
        followAll.click();

        String mainId=driver.getWindowHandle();
        BrowserUtils.closeWindows(driver,mainId);
        System.out.println(driver.getTitle());
    }
}
