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

    public String email(){
        return "opencart" + System.currentTimeMillis() + "@yopmail.com";
    }
    @DataProvider
    public Object[][] customerData(){
        return new  Object[][]{
                {"Rithica","B","9876643212","Rithica@123","no"},
                {"Sudhakar","V","9874543219","sudhakar@123","no"},
                {"Sahil","kumar","9876543234","sahil@123","yes"},
                {"Fathima","n","9876543215","fathu@123","yes"}
        };
    }
    @Test(dataProvider = "customerData",priority = 1)
    public void doRegisterTest(String firstName,String lastName,String num,
                               String password,String subscribe){
        Assert.assertTrue(registerPage.doRegisterNewCustomer(firstName,lastName,email(),num,password,subscribe));

    }
}

