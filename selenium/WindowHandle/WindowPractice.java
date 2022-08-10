package selenium.WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowPractice {
    @Test
    public  void windowTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickButton=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();
        String mainWindow=driver.getWindowHandle();//return page id from current driver location
        Set<String> windows=driver.getWindowHandles();//set bc unique
        //123 //123-124
        for (String window:windows){
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);//when you see two tapes you can use for each
                //if the windowid is not equals to the mainwindow id the switch to that window id.
            }
        }
        System.out.println(driver.getTitle());
        WebElement text=driver.findElement(By.tagName("h3"));
        System.out.println(text.getText());
    }
    @Test
    public  void  validateMainWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickButton=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();
        String mainWindow=driver.getWindowHandle();//return page id from current driver location
        Set<String> windows=driver.getWindowHandles();//set bc unique
        System.out.println(mainWindow);
        //123 //123-124
        for (String window:windows){
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);//when you see two tapes you can use for each
                //if the windowid is not equals to the mainwindow id the switch to that window id.
                driver.close();//will close the current window.

            }    }
           driver.switchTo().window(mainWindow);
        clickButton.click();
        driver.quit();//it will close the driver
        System.out.println(driver.getCurrentUrl());//noSuchSessionException bc driver close
    }

}
