package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;

    Properties properties;

    public WebDriver launchBrowser(Properties properties) {
      String browserName =  properties.getProperty("browser");
        System.out.println("the broswer name is :"+browserName);
        OptionsManager optionsManager = new OptionsManager(properties);

        switch(browserName.trim().toLowerCase()){
            case "chrome":
                driver = new ChromeDriver(optionsManager.getChromeOptions());
                break;
            case "edge":
                driver = new EdgeDriver(optionsManager.getEdgeOptions());
                break;
            default:
                System.out.println("Enter valid browser name: "+browserName);
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));
        return driver;
    }

    public Properties initProp(){
        properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("/Users/rithica/IdeaProjects/FirstFrameworkRithica/src/test/resources/config.properties");
            properties.load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
}

