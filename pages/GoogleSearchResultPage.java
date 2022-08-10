package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultPage {
    public  GoogleSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "result-stats")
    private WebElement resultStats;
    @FindBy(tagName = "h3")
    private List<WebElement>resultPageLinks;
    public int getResultLinksCount(){
        return resultPageLinks.size();
    }
    public  int getResultStatsCount(){
        //about 268,000,000
      String stats=  resultStats.getText().replace(",","");
        System.out.println(stats);
        //temp return 0,will fix later
        String[] words=stats.split(" ");
        int result=0;
        for (String word:words) {
            try {
           result=Integer.parseInt(word);
                System.out.println("Result number is:"+result);
                break;
            }catch (NumberFormatException ex){
                System.out.println("This is not a number:"+word);
                ex.printStackTrace();
            }
        }
        return result;
    }

}
