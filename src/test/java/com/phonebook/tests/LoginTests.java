package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTests(){
        clickOnLoginLink();
        fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        clickOnLoginButton();
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }
    @Test
    public void loginNegativeWithoutEmailTests(){
        clickOnLoginLink();
        fillregisterloginform(new User().setPassword("Ol_111111!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());

    }

}
