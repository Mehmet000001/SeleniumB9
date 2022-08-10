package selenium.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSPractice {
    @Test
    public  void validateJSOperators() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        JavascriptExecutor javascriptExecutor=driver;
        String title= javascriptExecutor.executeScript("return document.title").toString();
        System.out.println(title);
        WebElement browse=driver.findElement(By.linkText("Browse Course"));
        // browse.click();
        //actions.click(browse).perform();
        javascriptExecutor.executeScript("arguments[0].click()",browse);
        WebElement info=driver.findElement(By.xpath("//h2[.='information']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",info);
        Thread.sleep(2000);
        WebElement login=driver.findElement(By.linkText("Student login"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",login);
    }
}
