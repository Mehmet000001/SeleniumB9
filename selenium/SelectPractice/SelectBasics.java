package selenium.SelectPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectBasics {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement options=driver.findElement(By.id("dropdown"));
        Select select=new Select(options);
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);//it will pause the code in this line 2 sec.
        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByIndex(1);


    }
    @Test
    public void practice2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        WebElement option=driver.findElement(By.id("make-model-search-stocktype"));
        Select select=new Select(option);
        select.selectByValue("new");
        WebElement option1=driver.findElement(By.xpath("//select[@id='makes']"));///By.id("makes")
        Select select1=new Select(option1);
        select1.selectByValue("porsche");
        WebElement option2=driver.findElement(By.xpath("//select[@id='models']"));///By.id("models")
        Select model=new Select(option2);
        model.selectByVisibleText("911");
        WebElement search=driver.findElement(By.xpath("//div[@id='by-make-tab']//button"));
        search.click();

        WebElement resultHeader=driver.findElement(By.xpath("//*[@id='search-live-content']//h1"));
        String actual=resultHeader.getText();
        String expected="New Porsche 911 for sale";
        Assert.assertEquals(actual,expected,"Header assertion is failed after search ");
//       selectByValue(option,"new");
//       selectByValue(option1,"porsche");you can do like this you can call method.
//       selectByValue(option2,"911");

    }
    public  void selectByValue(WebElement element,String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }
}
