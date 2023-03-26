package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HWSaucePage {

    public HWSaucePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> allItems;

    public void allItemsInformation(String itemName){
        for(WebElement item : allItems){
            if(BrowserUtils.getText(item).contains(itemName)){
                item.click();
                break;
            }
        }
    }
}
