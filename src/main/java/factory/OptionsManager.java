package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Properties;

public class OptionsManager {
    private ChromeOptions co;
    private EdgeOptions eo;
    private Properties properties;

    public OptionsManager(Properties properties){
        this.properties = properties;
    }

    public ChromeOptions getChromeOptions(){
        co=new ChromeOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless"))){
            co.addArguments("--headless");
        }
        if (Boolean.parseBoolean(properties.getProperty("incognito"))){
            co.addArguments("--incognito");
        }
        return co;
    }

    public EdgeOptions getEdgeOptions(){
        eo=new EdgeOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless"))){
            eo.addArguments("--headless");
        }
        if (Boolean.parseBoolean(properties.getProperty("incognito"))){
            eo.addArguments("--incognito");
        }
        return eo;
    }
//    public EdgeOptions getEdgeOptions(){
//        eo.addArguments("--headless");
//        eo.addArguments("--incognito");
//        return eo;
//    }

}
