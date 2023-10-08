package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class ProductInfoPage {
    //1. private By locators
    //2. public Page Constructor
    //3. Public page actions/methods
    WebDriver driver;
    ElementUtil elementUtil;

    private By producttext =By.tagName("h1");
    private By productImageCount = By.xpath("//div[@id='content']//img");
    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getProductHeaderText(){
        return elementUtil.visibilityofElementLocated(AppConstants.MEDIUM_TIME,producttext).getText();
    }

    public int getProductImagesCount(){
        return elementUtil.visibilityofAllElementsLocated(AppConstants.MEDIUM_TIME,productImageCount).size();
    }


}
