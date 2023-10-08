package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest {
    @BeforeClass
    public void productInfoSetup(){
        accountPage = loginPage.login(AppConstants.USER_NAME,AppConstants.PASSWORD);
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
}
