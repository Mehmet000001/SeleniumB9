package selenium.HomeWorkUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    @Test
    public  void Case1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passW=driver.findElement(By.xpath("secret_sauce"));
        userName.sendKeys("standard_user");
        passW.sendKeys("secret_sauce");
        WebElement button=driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        WebElement dropDown= driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
        Select sortDropDown = new Select(dropDown);
        sortDropDown.selectByValue("lohi");
        List<WebElement> prices= driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
        // String to Double
        // Pars double
        List<Double> priceDoubleList= new ArrayList();

        for (int i = 0; i <prices.size() ; i++) {
            String price= prices.get(i).getText().substring(1);
            priceDoubleList.add(Double.parseDouble(price));
        }
        boolean isLowToHigh= true;
        for (int i = 0,k=1; k <priceDoubleList.size() ; i++,k++) {
            if (priceDoubleList.get(i)>priceDoubleList.get(k)){
                isLowToHigh=false;
                break;
            }
        }
    }
}
