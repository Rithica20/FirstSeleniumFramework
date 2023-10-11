package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountPage {
    //1. private By locators
    //2. public Page Constructor
    //3. Public page actions/methods

    WebDriver driver;
    ElementUtil elementUtil;


    private By search = By.name("search");
    private By searchIcon = By.xpath("//button[@class='btn btn-default btn-lg']");
    private By accountHeaders = By.tagName("h2");
    private By accountLinks = By.xpath("//div[@class='list-group']/a");

    public AccountPage(WebDriver driver){
        this.driver=driver;
        elementUtil = new ElementUtil(driver);

    }

    public String getTitle(){
        return elementUtil.title();
    }

    public List<String> isAccountHeadersExists(){
        List<WebElement> allheaders = elementUtil.visibilityofAllElementsLocated(AppConstants.SHORT_TIME,accountHeaders);
        List<String> actualHeaders = new ArrayList<>();
        for (WebElement e: allheaders){
            String text = e.getText();
            actualHeaders.add(text);
        }
        return actualHeaders;
    }
    public List<String> isAllAccountLinksExists(){
        List<WebElement> alllinkText = elementUtil.visibilityofAllElementsLocated(AppConstants.SHORT_TIME,accountLinks);
        List<String> actuallinks = new ArrayList<>();
        for (WebElement e: alllinkText){
            String text = e.getText();
            actuallinks.add(text);
        }
        return actuallinks;
    }
    public SearchResultsPage doSearch(String name){
        elementUtil.visibilityofElementLocated(AppConstants.MEDIUM_TIME,search).clear();
        elementUtil.visibilityofElementLocated(AppConstants.MEDIUM_TIME,search).sendKeys(name);
        elementUtil.getElement(searchIcon).click();
        return new SearchResultsPage(driver);
    }

}
