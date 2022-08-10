package selenium.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderPractice {
    @Test
    public  void  validateSlider(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(-40,0).perform();
        WebElement rangeText=driver.findElement(By.id("range"));
        moveSlider(driver,slider,rangeText,3);

    }
    //driver-->actions
    //slider--->clickandhold
    //rageText--->you need to use it in your loop to check the condition
    public  void  moveSlider(WebDriver driver,WebElement slider,WebElement rangeText,double targetNum){
        //target 3,2.5 moveslider 10 to the right side.

        Actions actions=new Actions(driver);
        double actualNum=Double.parseDouble(rangeText.getText());
        if (targetNum>2.5){
            int count=5;//you have to put after the while loop.
            while (actualNum!=targetNum){
                actions.clickAndHold(slider).moveByOffset(count,0).perform();
                actualNum=Double.parseDouble(rangeText.getText());
                count+=5;
            }
        }


    }
}
