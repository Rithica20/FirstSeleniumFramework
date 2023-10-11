package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage {
    //1. private By locators
    //2. public Page Constructor
    //3. Public page actions/methods
    WebDriver driver;
    ElementUtil elementUtil;
    Map<String,String> productData;

    private By producttext =By.tagName("h1");
    private By productImageCount = By.xpath("//div[@id='content']//img");
    private By productDataInfo = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]/li");
    private By productPriceInfo = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][2]/li");
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
    public void getProductDataInfo(){
        List<WebElement> allProductData = elementUtil.visibilityofAllElementsLocated(AppConstants.SHORT_TIME,productDataInfo);
//        Map<String,String> finalData = new HashMap<String,String>();
        for (WebElement e:allProductData){
            String text = e.getText();
            String key = text.split(":")[0].trim();
            String value = text.split(":")[1].trim();
//            finalData.put(key,value);
            productData.put(key,value);
        }
        //return finalData;
    }
    public void getProductPriceInfo(){
        List<WebElement> allProductPricceData = elementUtil.visibilityofAllElementsLocated(AppConstants.SHORT_TIME,productPriceInfo);
//        Map<String,String> finalPriceData = new HashMap<String,String>();
        String text = allProductPricceData.get(0).getText();
        String key = allProductPricceData.get(1).getText().split(":")[0].trim();
        String value = allProductPricceData.get(1).getText().split(":")[1].trim();
//        finalPriceData.put(key,value);
        productData.put(key,value);
        //return finalPriceData;
    }

    public Map<String, String> getProductData(){
//        getTitle();
//        getProductDataInfo();
//        getProductPriceInfo();
        productData = new HashMap<>();
        productData.put("name",getProductHeaderText());
        productData.put("imgcount",String.valueOf(getProductImagesCount()));
        getProductDataInfo();
        getProductPriceInfo();
        return productData;
    }

}
