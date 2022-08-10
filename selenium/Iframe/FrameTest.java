package selenium.Iframe;

import selenium.Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest {
    /*
TASK:
1- GO to the https://skpatro.github.io/demo/iframes/
2- click category1
3- from new page validate the title is ending with 'qavalidation'
4- Click category3
5- validate the url is equals to "https://qavalidation.com/category/softwaretesting/"
 */
    @Test
    public  void  practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();//instantiate the chromedriver
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement frame1=driver.findElement(By.id("Frame1"));
        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"qavalidation");
        String c1Title=driver.getTitle();
        Assert.assertTrue(c1Title.endsWith("qavalidation"));
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qavalidation.com/category/softwaretesting/");
    }
}
