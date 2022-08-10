package selenium.SelectPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectMethod {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select select = new Select(currency);
        WebElement firstOption = select.getFirstSelectedOption();
        //GetFirstOption method return WebElement of first selected option

        String actualOption = firstOption.getText();
        String expectedOption = "INR";
        Assert.assertEquals(actualOption, expectedOption);
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Thread.sleep(1000);
        Select select = new Select(currency);
        List<WebElement> options = select.getOptions();
        //get all the options text and store inside the list of string.
       List<String>actualText=getText(options);
       List<String>expectedText= Arrays.asList("Select","BDT","GBP","INR","AED","USD");
       Assert.assertEquals(actualText,expectedText);
    }

    //Create one method take the parameter as a list<WebElement>and return text from the webelements as the List<String>

    public List<String> getText(List<WebElement> options) {
        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : options) {
optionTexts.add(option.getText());

        }
        return optionTexts;
    }

}