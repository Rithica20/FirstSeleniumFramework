package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected SearchResultsPage searchResultsPage;

    protected ProductInfoPage productInfoPage;

    DriverFactory driverFactory;

    protected Properties properties;
   protected SoftAssert softAssert;
   protected RegisterPage registerPage;


    @BeforeTest
    public void setup(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driverFactory = new DriverFactory();
        softAssert=new SoftAssert();
        properties = driverFactory.initProp();
        driver = driverFactory.launchBrowser(properties);
        loginPage =new LoginPage(driver);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }


}
