package selenium.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    public static void switchByTitle(WebDriver driver, String title){
        Set<String>ids=driver.getWindowHandles();
        for (String id:ids){
            if (!driver.getTitle().contains(title)){
                driver.switchTo().window(id);
            }
        }

    }
    public static void closeWindows(WebDriver driver,String mainWindowId){
        Set<String>ids=driver.getWindowHandles();
        for (String id:ids){
            if (!id.equals(mainWindowId)){
                driver.switchTo().window(id);
                System.out.println(driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowId);


    }
    public  static  String getText(WebElement element){
        return element.getText().trim();
    }
    public static void  scrollIntoView(WebDriver driver,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);


    }
    public  static  void selectByVisibleText(WebElement element,String text){
        Select select=new Select(element);
        select.selectByVisibleText(text);
    }
    public  static void  getScreenShot(WebDriver driver,String packageName){
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"/src/test/java/selenium.screenshots/"+packageName+"/";
        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()+".png"));
        }catch (IOException e){
            System.out.println("The screenshot is not stored.");
            e.printStackTrace();
        }
    }
    public  static  void  safeClick(WebElement element,int timeSec){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),timeSec);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public  static  void sendKey(WebElement element,String text,int timeSec){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),timeSec);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public  static  String  getText(WebElement element,int timeSec){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),timeSec);
       return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();

    }
}
