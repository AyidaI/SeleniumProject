package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {
    WebDriver driver;

    @Test
    public void validateTheText() {
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicLoading = driver.findElement(By.linkText("Dynamic Loading"));
        dynamicLoading.click();

        WebElement example1 = driver.findElement(By.xpath("//a[.='Example 1: Element on page that is hidden']"));
        example1.click();

        WebElement startBtn = driver.findElement(By.xpath("//button[.='Start']"));
        startBtn.click();

        WebElement message = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message), "Hello World!");
    }

    @Test
    public void validateText2(){
        driver=DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicControl=driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControl.click();
        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement removeBtn=driver.findElement(By.xpath("//button[.='Remove']"));
        removeBtn.click();

        WebElement text=driver.findElement(By.id("message"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text), "It's gone!");
    }
}
