package academy;

import java.io.IOException;
// import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateTitle extends Base{

    @BeforeTest
    public void initializeTest() throws IOException {
        driver=initializeDriver();
        String url = props.getProperty("URL");
        System.out.println(url);
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
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
