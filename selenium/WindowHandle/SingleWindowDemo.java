package selenium.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class SingleWindowDemo {
    @Test
    public  void  validateSingleWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
        WebElement twitter = driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']"));
        twitter.click();

        String mainWindow = driver.getWindowHandle();//return page id from current driver location
        Set<String> windows = driver.getWindowHandles();//set bc unique
        System.out.println(mainWindow);

        for (String window : windows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);

            }
        }
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.name("session[username_or_email]"));
        userName.sendKeys("Alex");
    }}