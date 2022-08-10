package selenium.SelectPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firefox {
    @Test
    public void practice2() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
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
}
