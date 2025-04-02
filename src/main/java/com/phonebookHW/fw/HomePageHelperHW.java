package com.phonebookHW.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelperHW extends BaseHelperHW{
    public HomePageHelperHW(WebDriver driver) {

        super(driver);
    }
    public boolean isHomeComponentPresent(){

        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }

    public void clickOnHomeLink() {
        click(By.cssSelector("[href='/home']"));
    }
}
