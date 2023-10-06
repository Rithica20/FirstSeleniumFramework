package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    // declare elementutil
    // private by locator
    // public class constructor
    //public class methods

    WebDriver driver;
    ElementUtil elementUtil;

    private By searchResult = By.xpath("//div[@id='content']//h1");

    private By totalResultProducts = By.xpath("//div[@class='row']/div[contains(@class,'product-layout product-grid')]");
    private By menuBars = By.xpath("//ul[@class='nav navbar-nav']/li/a");

    private By firstProduct = By.xpath("//h4//a[text()='MacBook']");

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String isSearchResultTextExists(){
       return elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,searchResult).getText();
    }

    public List<WebElement> productExistsInSearchResult(){
        List<WebElement> allProducts = elementUtil.visibilityofAllElementsLocated(AppConstants.MEDIUM_TIME,totalResultProducts);
//        List<String> availableProducts = new ArrayList<>();
//        for (WebElement e:allProducts){
//            String text = e.getText();
//            availableProducts.add(text);
//        }
        return allProducts;
    }
    public List<String> isMenuBarsExists(){
        List<WebElement> allmenu = elementUtil.visibilityofAllElementsLocated(AppConstants.SHORT_TIME,menuBars);
        List<String> availableMenu = new ArrayList<>();
        for (WebElement e:allmenu){
            String text = e.getText();
            availableMenu.add(text);
        }
        return availableMenu;
    }
    public void doClickFirstProduct(){
        elementUtil.visibilityofElementLocated(AppConstants.SHORT_TIME,firstProduct).click();
    }
}
