package academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    public WebDriver driver;
    public Properties props;
    public WebDriver initializeDriver() throws IOException {
        
        //initialize property file
        props = new Properties();
        FileInputStream fis = new FileInputStream("/Users/andrew/dev0/JavaProjects/firstframework/src/main/java/academy/resources/data.properties");

        //load property file
        props.load(fis);
        //get browser value from property file
        String brwser = props.getProperty("browser");

        //initialize browser driver
        //chrome
        if(brwser.toString().equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/andrew/dev0/files/chromedriver");
            driver = new ChromeDriver();
            System.out.println("OK Chrome than...");
        }
        //firefox
        else if(brwser.toString().equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver","/Users/andrew/dev0/files/firefoxdriver");
            driver = new FirefoxDriver();
            System.out.println("OK Firefox than...");
        }
        //everything else
        else{
            System.out.println("IE must die...");
            System.out.println("no IF fro this browser. Fix Base.java if you really need it");
        }
        //timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
