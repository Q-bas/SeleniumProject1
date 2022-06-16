package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By signin= By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
    By clsPopUp= By.xpath("//button[normalize-space()='NO THANKS']");
    By pgHdr = By.cssSelector("div[class='text-center'] h2");
    By nvBr = By.cssSelector(".nav.navbar-nav.navbar-right");
    
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public  WebElement logIn() {
        return driver.findElement(signin);
    }
  
    public WebElement closePopUp() {
        return driver.findElement(clsPopUp);       
    }

    public WebElement pageHeader() {
        return driver.findElement(pgHdr);
    }

    public WebElement navBar() {
        return driver.findElement(nvBr);
    }
}
