package academy;

import java.io.IOException;
import java.time.Duration;

// import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
// import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
// import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base{

    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initializeTest() throws IOException {
        driver=initializeDriver();
        log.info("Driver is initialized");
    }
    
    //test+dataprovider added
    @Test(dataProvider="getData")
    public void basePageNavigation(String username, String password, String text) throws IOException {
        
        
        
        //PageFactory classes import
        LandingPage lp = new LandingPage(driver);
        LoginPage lip = new LoginPage(driver);


        String url = props.getProperty("URL");
        log.info(url);
        driver.get(url);
        log.info("Navigated to Home Page");

        //explicit wait for page load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lp.logIn()));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.stop();");

        //Test case steps
        // Uncoment if popup appears again
        // add try-catch
        // lp.closePopUp().click();
        lp.logIn().click();

        Assert.assertTrue(lip.emailField().isDisplayed());
        log.info("email field is shown");
        lip.emailField().sendKeys(username);
        lip.passwordField().sendKeys(password);
        log.info(username+" "+password+" "+ text);
        lip.signinButton().click();
        // Assert.assertTrue(lip.getErrorMessage().isDisplayed(), "Error not visible");
        // Assert.assertEquals(lip.getErrorMessage().getText(), "Invalid email or password.");
    }

    // REWRITE THIS SHIT. add excel source
    //here set values like login+password
    @DataProvider
    public Object getData(){
        Object[][] data = new Object[2][3];
        data[0][0] = "a@a.a";
        data[0][1] = "pwd";
        data[0][2]= "Admin user";

        data[1][0] = "b@a.a";
        data[1][1] = "pwd2";
        data[1][2]= "Restricted user";
        return data;
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
    
}
