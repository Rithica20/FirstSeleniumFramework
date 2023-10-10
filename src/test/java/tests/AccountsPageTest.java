package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    //precondition to do login
    @BeforeClass
    public void login(){

        accountPage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
    }
    @Test(priority = 1)
    public void getTitleTest(){
        String title = accountPage.getTitle();
        Assert.assertEquals(title,AppConstants.LOGIN_ACCOUNT_TITLLE);
    }
    @Test(priority = 2)
    public void isAccountHeadersExistsTest(){
       List<String> text = accountPage.isAccountHeadersExists();
       Assert.assertEquals(text,AppConstants.ALL_HEADERS_IN_ACCOUNT_PAGE);
    }
    @Test(priority = 3)
    public void isAllAccountLinksExistsTest(){
        List<String> text = accountPage.isAllAccountLinksExists();
        Assert.assertEquals(text,AppConstants.ALL_LINKS_IN_ACCOUNT_PAGE);
    }
    @Test(priority = 4)
    public void doSearch(){
        accountPage.doSearch("macbook");

    }
}
