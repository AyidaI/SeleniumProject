package Homework.com.test.sauces.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void loginFunctionality(String username, String password) throws InterruptedException {
        Thread.sleep(1000);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
