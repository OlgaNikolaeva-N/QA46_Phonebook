package com.phonebook.tests;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTests(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Sign Out']")));

    }
    @Test
    public void loginNegativeWithoutEmailTests(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setPassword("Ol_111111!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());

    }

}
