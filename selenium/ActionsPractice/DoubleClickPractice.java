package selenium.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class DoubleClickPractice {
    @Test
    public  void  validateDoubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.primefaces.org/showcase/ui/misc/effect.xhtml?jfwid=43ce3");
        List<WebElement>clicks=driver.findElements(By.xpath("//div[contains(text(),'click')]"));
        Actions actions=new Actions(driver);
        //we wnt to click one time if it is click
        //we want to click two time if it is doubleclick
        for (WebElement click:clicks){
            if (click.getText().equals("click"))
                click.click();

                if (click.getText().equals("doubleclick"))
                    actions.doubleClick(click).perform();


        }
    }
}
