package selenium.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsyHomePage {
    //    TASK:
//    Go to the etsy.com
//    search "java programming mug"
//    validate all the results we have java, programming or mug.
    public EtsyHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(id="global-enhancements-search-query")
    WebElement searchBox;
    @FindBy(xpath="//div[contains(@class, 'search-listings-group')]//h3")
    List<WebElement>items;

//    public List<String>getItemText(){
//        List<String>texts=new ArrayList<>();
//        for (WebElement item:items){
//            texts.add(item.getText().toLowerCase().trim());
//        }
//        return texts;
//    }
//if every text contains either java programing or mug return true ,otherwise return false
    public boolean checkItemText(){
        for (WebElement item:items){
            String result=item.getText().toLowerCase().trim();
            if (!result.contains("java")&&!result.contains("programming")&&!result.contains("mug")){
                System.out.println(result);
                return false;
            }
        }
        return true;
    }
    public void sendSearchInput(String input){
        searchBox.sendKeys("Java programing mug"+ Keys.ENTER);
    }

}