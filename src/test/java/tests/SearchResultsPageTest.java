package tests;

import base.BaseTest;
import constants.AppConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;

import java.util.List;

public class SearchResultsPageTest extends BaseTest {
    @BeforeClass
    public void login(){
        accountPage = loginPage.login(AppConstants.USER_NAME,AppConstants.PASSWORD);
        searchResultsPage = accountPage.doSearch(AppConstants.SEARCH_FOR_PRODUCT);
    }
    @Test(priority = 1)
    public void isSearchResultTextExistsTest(){
        String text = searchResultsPage.isSearchResultTextExists();
        Assert.assertEquals(text,AppConstants.SEARCH_FOR_PRODUCT_RESULT);
    }
//    @Test(priority = 2)
//    public void productExistsInSearchResultTest(){
//        List<WebElement> result = searchResultsPage.productExistsInSearchResult();
//        Assert.assertEquals(result,3);
//    }
    @Test(priority =3)
    public void isMenuBarsExistsTest(){
        List<String> result=searchResultsPage.isMenuBarsExists();
        Assert.assertEquals(result,AppConstants.ALL_MENU_INSEARCH_RESULT);
    }
    @Test(priority = 4)
    public void doClickFirstProductTest(){
        searchResultsPage.doClickFirstProduct();
    }
}
