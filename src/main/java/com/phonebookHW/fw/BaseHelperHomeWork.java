package com.phonebookHW.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelperHomeWork{
    WebDriver driver;

    public BaseHelperHomeWork(WebDriver driver) {

        this.driver=driver;
    }

    public boolean isElementPresent(By locator){

        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        if (text!=null){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);}
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }


    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String takeScreenshotHW(){
        File tmphw = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screensothw = new File("screensotshw/screenhw-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmphw,screensothw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screensothw.getAbsolutePath();
    }
}
