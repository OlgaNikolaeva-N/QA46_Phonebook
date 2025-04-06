package com.phonebook.tests;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginPositiveTests(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Sign Out']")));

    }
    @Test(priority = 2)
    public void loginNegativeWithoutEmailTests(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setPassword("Ol_111111!"));
        //app.getUser().pause(10000);
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());


    }

}
