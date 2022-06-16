package academy;

import java.io.IOException;
// import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateTitle extends Base{

    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initializeTest() throws IOException {
        driver=initializeDriver();
        String url = props.getProperty("URL");
        log.info(url);
        driver.get(url);
    }
    
    //test+dataprovider added
    @Test()
    public void basePageNavigation() throws IOException {
        
        //PageFactory classes import
        LandingPage lp = new LandingPage(driver);
        
        //Test case steps
        
        // Uncoment if popup appears again
        // add try-catch
        // lp.closePopUp().click();
        Assert.assertEquals(lp.pageHeader().getText(), "FEATURED COURSES");
        log.info("Title shown "+lp.pageHeader().getText());
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
