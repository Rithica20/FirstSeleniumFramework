package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoPageTest extends BaseTest {
    @BeforeClass
    public void productInfoSetup(){

        accountPage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
//        accountPage = loginPage.login(AppConstants.USER_NAME,AppConstants.PASSWORD);
//        accountPage = loginPage.login(AppConstants.USER_NAME,AppConstants.PASSWORD);
//        searchResultsPage = accountPage.doSearch("macbook");
//        productInfoPage = searchResultsPage.selectProduct("MacBook Air");
    }
    @DataProvider
    public Object[][] productData(){
       return  new Object[][]
        {
            {"macbook","MacBook Air"},
            {"macbook","MacBook Pro"},
            {"samsung","Samsung SyncMaster 941BW"},
                {"canon","Canon EOS 5D"}
        };
    }
    @Test(dataProvider = "productData")
    public void getProductHeaderText(String searchKey,String productName){
        searchResultsPage = accountPage.doSearch(searchKey);
        productInfoPage = searchResultsPage.selectProduct(productName);
        String text = productInfoPage.getProductHeaderText();
        Assert.assertEquals(text,productName);
    }
    @DataProvider
    public Object[][] product(){
        return new Object[][]{
                {"macbook","MacBook Air",4},
                {"macbook","MacBook Pro",4},
                {"samsung","Samsung SyncMaster 941BW",1},
                {"canon","Canon EOS 5D",3}
        };
    }
    @Test(dataProvider = "product")
    public void productImagesCount(String searchKey,String productName, int expectedProductImagesCount){
        searchResultsPage = accountPage.doSearch(searchKey);
        productInfoPage = searchResultsPage.selectProduct(productName);
        int count = productInfoPage.getProductImagesCount();
        Assert.assertEquals(count,expectedProductImagesCount);
    }
    @Test
    public void getProductDataTest(){
        searchResultsPage = accountPage.doSearch("macbook");
        productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
        Map<String,String> info = productInfoPage.getProductData();
        System.out.println(info);
//        Assert.assertEquals(info.get("Brand"),"Apple"); //as we are using three assert here if 1st assert fails hard assert will not got to next assert
//        Assert.assertEquals(info.get("Availability"),"In Stock");
//        Assert.assertEquals(info.get("name"),"MacBook Pro");

        softAssert.assertEquals(info.get("Brand"),"Apple");
        softAssert.assertEquals(info.get("Availability"),"In Stock");
        softAssert.assertEquals(info.get("name"),"MacBook Pro");
        softAssert.assertEquals(info.get("Ex Tax"),"$2,000.00");
        softAssert.assertAll();
    }
}
//{Brand=Apple, Availability=In Stock,
//        imgcount=4, name=MacBook Pro,
//        Product Code=Product 18,
//        Reward Points=800,
//        $2,000.00=$2,000.00}
