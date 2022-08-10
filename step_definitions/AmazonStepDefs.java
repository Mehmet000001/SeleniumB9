package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonStepDefs {
    WebDriver driver;
    String currentUrl;
    String title;
    @Given("I am on amazon home page")
    public void i_am_on_amazon_home_page() {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        System.out.println("I have navigate to Amazon's home page");
    }
    @When("I get the url")
    public void t_get_the_url() {
         currentUrl=driver.getCurrentUrl();
        System.out.println("I will be getting Amazon's url"+currentUrl);
    }
    @When("I get the home page title")
    public void i_get_the_home_page_title() {
        title= driver.getTitle();
        System.out.println("I will be getting Amazon's page title"+title);
    }
//
//    @When("I get all the links")
//    public void i_get_all_the_links() {
//
//        System.out.println("I will be getting  all the links from home page");
//    }

    @Then("url and title are valid")
    public void url_and_title_are_valid() {
        Assert.assertEquals("Failed to validate url", currentUrl,"https://www.amazon.com/");
        Assert.assertEquals("failed to validate title", title,"Amazon.com. Spend less. Smile more.");
        System.out.println("I will be title and url validations ");
    }

    @Given("I am on amazon's home page")
    public void i_am_on_amazon_s_home_page() {
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.get("https://www.amazon.com/");
    }
    @When("I search for selenium cookbook")
    public void i_search_for_selenium_cookbook() {
       WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
       searchBox.sendKeys("selenium cookbook"+ Keys.ENTER);

    }
    @Then("I should see on selenium cookbook related results only")
    public void i_should_see_on_selenium_cookbook_related_results_only() {
     List<WebElement> resultList = driver.findElements(By.tagName("h2"));
     for (WebElement result:resultList){
         String actualResultText=result.getText().toLowerCase().trim();
         Assert.assertTrue(actualResultText.contains("cookbook")||actualResultText.contains("selenium"));
     }

    }

    @When("I search for {string}")
    public void i_search_for(String product) {
   WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
   searchBox.sendKeys(product+Keys.ENTER);
    }
    @Then("the result page should have the  max price of iphone more than ${int}")
    public void the_result_page_should_have_the_max_price_of_iphone_more_than_$(Integer price) {
        int maxPrice=0;
     List<WebElement> pricesList=driver.findElements(By.className("a-price-whole"));
     for (int i=0;i<pricesList.size();i++) {
         WebElement priceElement = pricesList.get(i);
         System.out.println(priceElement.getText());
         String priceStr = priceElement.getText().replace(",", "").trim();
         if (!priceStr.isEmpty()) {
             int currentProductPrice = Integer.parseInt(priceStr);
             if (currentProductPrice > maxPrice) {
                 maxPrice = currentProductPrice;
             }
         }
     }
        System.out.println("Max price:"+maxPrice);
     Assert.assertTrue(maxPrice>price);
    }
}
