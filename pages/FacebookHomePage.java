package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FacebookHomePage {
    public FacebookHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[@data-testid='open-registration-form-button']")
    private WebElement createNewAccountButton;

    @FindBy(name="firstname")
    private WebElement firstNameField;

    @FindBy(name="lastname")
    private WebElement lastNameField;

    @FindBy(name = "reg_email__")
    private WebElement emailField;

    @FindBy(name = "reg_passwd__")
    private WebElement passwordField;

    @FindBy(id="month")
    private WebElement monthDropDown;

    @FindBy(id="day")
    private WebElement dayDropDown;

    @FindBy(id="year")
    private WebElement yearDropDown;

    @FindBy(xpath = "//label[contains(text(),'Custom')]")
    private WebElement customRadioButton;

    @FindBy(xpath = "//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']")
    private WebElement closeRegistrationButton;
    @FindBy(id = "email")
    private WebElement signInEmailField;

    @FindBy(id = "pass")
    private WebElement signInPasswordField;

    @FindBy(xpath = "//button[@data-testid='royal_login_button']")
    private WebElement loginButton;

    public void loginToFacebook(String username,String password){
        signInEmailField.sendKeys(username);
        signInEmailField.sendKeys(password);
        loginButton.click();
    }


    public void clickToCreateNewAccount(){
        createNewAccountButton.click();
    }

    public void fillUpRegForm(String firstName, String lastName, String email, String password, String birthMonth,
                              String birthDay, String birthYear){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        Select select=new Select(monthDropDown);
        select.selectByVisibleText(birthMonth);

        select=new Select(dayDropDown);
        select.selectByVisibleText(birthDay);

        select=new Select(yearDropDown);
        select.selectByVisibleText(birthYear);

        customRadioButton.click();



    }
    public  void closeRegistrationForm(){
        closeRegistrationButton.click();
    }
}
