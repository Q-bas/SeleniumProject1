package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    By emailFld = By.id("user_email");
    By pwdFld = By.id("user_password");
    By sgnBtn = By.xpath("//input[@name='commit']");
    By errMsg = By.xpath("//div[@role='alert']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement emailField() {
        return driver.findElement(emailFld);
    }
    public WebElement passwordField(){
        return driver.findElement(pwdFld);
    }
    public WebElement signinButton(){
        return driver.findElement(sgnBtn);//find why it dissapears
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errMsg);//find why it dissapears
    }


}
