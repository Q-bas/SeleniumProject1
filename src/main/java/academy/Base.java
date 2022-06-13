package academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    public WebDriver driver;
    public void initializeDriver() throws IOException {
        
        //initialize property file
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/academy/Base.java");

        //load property file
        props.load(fis);
        //get browser value from property file
        String brwser = props.getProperty("browser");

        //initialize browser driver
        //chrome
        if(brwser=="chrome"){
            System.setProperty("webdriver.chrome.driver","/Users/andrew/dev0/files/chromedriver");
            driver = new ChromeDriver();
        }
        //firefox
        else if(brwser=="firefox"){
            System.setProperty("webdriver.firefox.driver","/Users/andrew/dev0/files/firefoxdriver");
            driver = new FirefoxDriver();
        }
        //everything else
        else{
            System.out.println("IE must die...");
            System.out.println("no IF fro this browser. Fix Base.java if you really need it");
        }
        //timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
    }
}
