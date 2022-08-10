package selenium.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContextClick {
    @Test
    public void rightClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();///don't forget put perform() method actions

        }
        @Test
        public  void validateName(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.navigate().to("https://the-internet.herokuapp.com/hovers");
            List<WebElement>names=driver.findElements(By.xpath("//h5"));
            List<WebElement>pictures=driver.findElements(By.xpath("//div[@id='content']//img"));
            //we will hover over the mouse on top of each pic and at the same time will get the text
            Actions actions=new Actions(driver);
            List<String>allNames=new ArrayList<>();
            for (int i=0;i<names.size();i++){
                actions.moveToElement(pictures.get(i)).perform();//moves the mouse to the given element
                allNames.add(names.get(i).getText());//will get the text from each names elemenent and store into the allName

            }
            List<String>expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
            Assert.assertEquals(allNames,expectedNames,"NAME validation is not passing");
    }
}
