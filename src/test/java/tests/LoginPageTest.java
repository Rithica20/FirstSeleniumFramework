package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void getTitleTest(){
        String title = loginPage.getTitle();
        Assert.assertEquals(title,AppConstants.TITLE);
    }

    @Test(priority = 2)
    public void getCurrentUrlTest(){
        String url = loginPage.getCurrentUrl();
        Assert.assertTrue(url.contains(AppConstants.URL_FRACTION));
    }

    @Test(priority = 3)
    public void getNewCustomerTest(){
        String text = loginPage.getNewCustomer();
        Assert.assertEquals(text,AppConstants.NEW_CUSTOMER_TEXT);
    }

    @Test(priority = 4)
    public void doLogin(){
//        String url = loginPage.login(AppConstants.USER_NAME,AppConstants.PASSWORD);
//        Assert.assertEquals(url,AppConstants.LOGIN_ACCOUNT_TITLLE);
        accountPage = loginPage.login(AppConstants.USER_NAME,AppConstants.PASSWORD);
        Assert.assertEquals(accountPage.getTitle(),AppConstants.LOGIN_ACCOUNT_TITLLE);
    }
}
