package Homework.com.test.sauces.tests;

import Homework.com.test.sauces.pages.LoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceTests extends BaseTest{

    @Test
    public void validateProducts() throws InterruptedException {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginFunctionality(ConfigReader.readProperty("QA_username="),
                ConfigReader.readProperty("QA_password"));


    }
}
