package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AccountPage;
import pages.LoginPage;
import pages.ProductInfoPage;
import pages.SearchResultsPage;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    protected AccountPage accountPage;
    protected SearchResultsPage searchResultsPage;

    protected ProductInfoPage productInfoPage;

    DriverFactory driverFactory;

    protected Properties properties;


    @BeforeTest
    public void setup(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
       driverFactory =new DriverFactory();
       properties = driverFactory.initProp();
       driver = driverFactory.launchBrowser(properties);
        loginPage =new LoginPage(driver);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }


}
