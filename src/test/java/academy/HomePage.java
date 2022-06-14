package academy;

import java.io.IOException;
// import java.time.Duration;

// import org.openqa.selenium.By;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base{

    @Test
    public void basePageNavigation() throws IOException {
        driver=initializeDriver();
        driver.get("http://qaclickacademy.com/");
        LandingPage lp = new LandingPage(driver);
        LoginPage lip = new LoginPage(driver);
        
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sumome-react-wysiwyg-move-handle")));
        lp.closePopUp().click();
        lp.logIn().click();
        lip.emailField().sendKeys("email@m.mail");
        lip.passwordField().sendKeys("pwd");
        lip.signinButton().click();
    }
    
}
