package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {
    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;


    Properties properties;

    public OptionsManager(Properties properties){
        this.properties = properties;
    }

    public ChromeOptions getChromeOption(){
        co = new ChromeOptions();
        if(Boolean.parseBoolean(properties.getProperty("headless"))){
            co.addArguments("--headless");
        if (Boolean.parseBoolean(properties.getProperty("incognito"))){
            co.addArguments("--incognito");
        }
        }
        return co;
    }
    public FirefoxOptions getFireFoxOption(){
        fo=new FirefoxOptions();
        if(Boolean.parseBoolean(properties.getProperty("headless"))){
            fo.addArguments("--headless");
        if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
            fo.addArguments("--incognito");
        }
        }
        return fo;
    }
    public EdgeOptions getEdgeOption(){
        eo= new EdgeOptions();
        if(Boolean.parseBoolean(properties.getProperty("headless"))){
            eo.addArguments("--headless");
            if (Boolean.parseBoolean(properties.getProperty("incognito"))) {
                eo.addArguments("--incognito");
            }
        }
        return eo;
    }
}
