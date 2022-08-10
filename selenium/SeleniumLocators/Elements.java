package selenium.SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Elements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();//webdriver is interface
        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> links=driver.findElements(By.xpath("//ul//a"));
        //task print all the text from the links.
        for (WebElement link:links){
            System.out.println(link.getText());
        }
        //Task print only the links which has more than 10  letters.
        for (WebElement link1:links){
            if (link1.getText().length()>10){///getText() return string
                System.out.println(link1.getText());
            }
        }
        //go to the typos find the p tags and store them as list of webelement then print the length of each text.
        WebElement typos=driver.findElement(By.xpath("//a[.='Typos']"));
        typos.click();
        List<WebElement>ps=driver.findElements(By.xpath("//p"));
        for (WebElement p:ps){
            System.out.println(p.getText().length());
        }
    }
}
