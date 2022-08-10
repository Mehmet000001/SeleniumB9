package selenium.Project2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FirstPart {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testCase1() {
        WebElement emptychart = driver.findElement(By.xpath("//span[.='(empty)']"));
        boolean emptybox = emptychart.isDisplayed();
        Assert.assertTrue(emptybox);
        List<WebElement> productPrice1 = driver.findElements(By.xpath("//span[@class='price product-price']"));
        List<WebElement> displayedProductPrices = new ArrayList<>();
        List<Double> prices = new ArrayList<>();//this list for the ascending order of prices
        for (int i = 0; i < productPrice1.size(); i++) {
            if (productPrice1.get(i).isDisplayed()) { // it will help you to get the displayed prices from the webpage
                displayedProductPrices.add(productPrice1.get(i));
            }
        }
        TreeSet<Double> ascendingOrder = new TreeSet<>();
        for (WebElement price : displayedProductPrices) {
            ascendingOrder.add(Double.parseDouble(price.getText().substring(1)));

        }
        for (Double price1 : ascendingOrder) {
            prices.add(price1);
        }
        double actualCheapest = prices.get(0);
        double expectedCheapest = 16.40;
        Assert.assertEquals(actualCheapest, expectedCheapest);

        int indexNUmber=-1;
        for (int i = 0; i < displayedProductPrices.size(); i++) {
            double price = Double.parseDouble(displayedProductPrices.get(i).getText().substring(1));
            if (price == actualCheapest) {
                indexNUmber = i;
                break;
            }
        }
        List<WebElement> productNames = driver.findElements(By.xpath("//a[@class=\"product-name\"]"));
        System.out.println(productNames.get(indexNUmber).getText());
        List<WebElement> pricesall = driver.findElements(By.xpath("//div[@itemprop='offers']//span[contains(text(),'$20.50')]"));
        double actualPrice=0;
        double actualPricerate=0;
        for (WebElement element : pricesall) {
            if (element.isDisplayed()) {
                actualPrice = Double.parseDouble(element.getText().substring(1));
                double expectedPrice = 20.50;
                Assert.assertEquals(actualPrice, expectedPrice);
            }
        }
        List<WebElement> discount = driver.findElements(By.xpath("//div[@itemprop='offers']//span[contains(text(),'-20%')]"));

        for (WebElement element : discount) {
            if (element.isDisplayed()) {
                actualPricerate = Double.parseDouble(element.getText().substring(1, 3));
                double expectedPrice = 20;
                Assert.assertEquals(actualPricerate, expectedPrice);
            }
        }
        Double actualcheck=actualCheapest;
        Double expectedcheck=(actualPrice)-(actualPrice*actualPricerate)/100;
        Assert.assertEquals(actualcheck,expectedcheck);

    }
    }

