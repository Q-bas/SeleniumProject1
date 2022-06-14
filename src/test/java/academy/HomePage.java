package academy;

import java.io.IOException;
// import java.time.Duration;

import org.testng.annotations.DataProvider;
// import org.openqa.selenium.By;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base{

    @Test(dataProvider="getData")
    public void basePageNavigation(String username, String password) throws IOException {
        driver=initializeDriver();
        driver.get("http://qaclickacademy.com/");
        LandingPage lp = new LandingPage(driver);
        LoginPage lip = new LoginPage(driver);
        
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sumome-react-wysiwyg-move-handle")));
        lp.closePopUp().click();
        lp.logIn().click();
        lip.emailField().sendKeys(username);
        lip.passwordField().sendKeys(password);
        lip.signinButton().click();
        //System.out.println(text);
    }
    @DataProvider
    public Object getData(){
        Object[][] data = new Object[1][2];
        data[0][0] = "a@a.a";
        data[0][1] = "pwd";
        //data[0][2]= "Restricted user";

        return data;
    }
    
}
