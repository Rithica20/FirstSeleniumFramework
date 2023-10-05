package utils;

import frameworkexception.CustomException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {
    WebDriver driver;

    public WebDriver launchBroswer(String browsername) throws CustomException {

        if (browsername == null) {
            System.out.println("browsername cannot be null");
        }
        switch (browsername.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new CustomException("Broswer name is not valid exception");
        }
        return driver;
    }

    public void launchUrl(String url){
        driver.get(url);
    }
    public String title (){
        return driver.getTitle();
    }
    public void closeBrowser(){
        driver.quit();
    }
}
