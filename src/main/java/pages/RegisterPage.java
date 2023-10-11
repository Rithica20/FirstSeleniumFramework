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
 private  By firstname =By.name("firstname");
 private By lastname = By.name("lastname");
 private By email = By.name("email");
 private By telephone = By.name("telephone");
 private By pswd = By.name("password");
 private By confirmpswd =By.name("confirm");
 private By checkbox = By.name("agree");
 private By continueBtn = By.xpath("//input[@value='Continue']");
 private By ContinueBtn = By.linkText("Continue");

 public RegisterPage(WebDriver driver){
     this.driver = driver;
     elementUtil = new ElementUtil(driver);
 }

public String doRegisterNewCustomer(String firstName, String lastName, String mail, String num, String password, String confrimpasswprd){
     elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,firstname).clear();
     elementUtil.doSendKeys(firstname,firstName);
     elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,lastname).clear();
     elementUtil.doSendKeys(lastname,lastName);
     elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,email).clear();
     elementUtil.doSendKeys(email,mail);
     elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,telephone).clear();
     elementUtil.doSendKeys(telephone,num);
     elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,pswd).clear();
     elementUtil.doSendKeys(pswd,password);
     elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,confirmpswd).clear();
     elementUtil.doSendKeys(confirmpswd,confrimpasswprd);
     elementUtil.doClick(checkbox);
     elementUtil.doClick(continueBtn);
     elementUtil.doClick(continueBtn);
//     return elementUtil.urlContains(AppConstants.REGISTER_PAGE_URL_FRACTION,AppConstants.MEDIUM_TIME);
        return driver.getCurrentUrl();
}

}
