package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class FluentlyWait {

    WebDriver driver;
    @Test
    public void fluentWaitTest(){
        driver=DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicControl=driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControl.click();
        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement removeBtn=driver.findElement(By.xpath("//button[.='Remove']"));
        removeBtn.click();

        Wait<WebDriver> fluentWait = new org.openqa.selenium.support.ui.FluentWait<>(driver) //polymorphism
        .pollingEvery(Duration.ofSeconds(3))
                .withMessage("text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement message = fluentWait.until(mydriver->driver.findElement(By.xpath("//p[@id='message']")));
        System.out.println(BrowserUtils.getText(message));


    }
}
