package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class LoginPage {

    //1. private By locators
    //2. public Page Constructor
    //3. Public page actions/methods

    private WebDriver driver;
    private ElementUtil elementUtil;




    private By email = By.name("email");
    private By password = By.name("password");

    private By loginBtn = By.xpath("//input[@value='Login']");

    private By newCustomer = By.xpath("//h2[text()='New Customer']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        elementUtil = new ElementUtil(driver);
    }
    public String getTitle(){
        //return driver.getTitle();
       return  elementUtil.title();
    }

    public String getCurrentUrl(){
        //return driver.getCurrentUrl();
        return elementUtil.urlContains(AppConstants.URL_FRACTION, AppConstants.SHORT_TIME);
    }
    public String getNewCustomer(){
        return elementUtil.doElementGetText(newCustomer);
    }
    public AccountPage login(String username, String loginpassword){
//        driver.findElement(email).sendKeys(username);
//        driver.findElement(password).sendKeys(loginpassword);
//        driver.findElement(loginBtn).click();
        elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,email).sendKeys(username);
        elementUtil.doSendKeys(password,loginpassword);
        elementUtil.doClick(loginBtn);
//        return driver.getTitle();
//        AccountPage accountpage = new AccountPage(driver);
        return new AccountPage(driver);
    }
}
