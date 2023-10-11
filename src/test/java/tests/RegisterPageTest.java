package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    @BeforeClass
    public void doLogin(){
       registerPage = loginPage.clickRegister();
    }
    @DataProvider
    public Object[][] customerData(){
        return new  Object[][]{
                {"Rithi","B","rithi@gmail.com","9876643212","Rithica@123","Rithica@123"},
                {"Sudhak","V","sudhak@gmail.com","9874543219","sudhakar@123","sudhakar@123"},
                {"Sah","kumar","sah@gmail.com","9876543234","sahil@123","sahil@123"},
                {"Fathu","n","fatuu@gmail.com","9876543215","fathu@123","fathu@123"}
        };
    }
    @Test(dataProvider = "customerData",priority = 1)
    public void doRegisterTest(String firstName,String lastName,String mail,String num,
                               String password,String confrimpasswprd){
       String url = registerPage.doRegisterNewCustomer(firstName,lastName,mail,num,password,confrimpasswprd);
        Assert.assertEquals(url,AppConstants.REGISTER_PAGE_URL_FRACTION);
    }
}

