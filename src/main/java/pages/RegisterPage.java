package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class RegisterPage {
    //elementutil
    //private by locator
    //public class constructor
    //public page methods
    WebDriver driver;
    ElementUtil elementUtil;
    private By firstname = By.name("firstname");
    private By lastname = By.name("lastname");
    private By email = By.name("email");
    private By telephone = By.name("telephone");
    private By pswd = By.name("password");
    private By confirmpswd = By.name("confirm");
    private By checkbox = By.name("agree");

    private By subscribeYes = By.xpath("//label[normalize-space()='Yes']");
    private By subscribeNo = By.xpath("//label[normalize-space()='No']");
    private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
    private By successMessg = By.cssSelector("div#content h1");
    private By logoutLink = By.linkText("Logout");
    private By registerLink = By.linkText("Register");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public boolean doRegisterNewCustomer(String firstName, String lastName, String mail, String num, String password, String subcribe) {
        elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,registerLink);
        elementUtil.doSendKeys(this.firstname,firstName);
        elementUtil.doSendKeys(this.lastname,lastName);
        elementUtil.doSendKeys(this.email,mail);
        elementUtil.doSendKeys(this.telephone,num);
        elementUtil.doSendKeys(this.pswd,password);
        elementUtil.doSendKeys(this.confirmpswd,password);
        if (subcribe.equalsIgnoreCase("yes")){
            elementUtil.doClick(subscribeYes);
        }
        else {
            elementUtil.doClick(subscribeNo);
        }
        elementUtil.doClick(checkbox);
        elementUtil.doClick(continueButton);

        String msg = elementUtil.visibilityofElementLocated(AppConstants.MEDIUM_TIME,successMessg).getText();
        if (msg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)){
            elementUtil.doClick(logoutLink);
            elementUtil.doClick(registerLink);
            return true;
        }
        return false;
    }
}

