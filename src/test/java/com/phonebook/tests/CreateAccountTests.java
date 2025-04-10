package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSingOutButtonPresent());
    }

    public boolean isSingOutButtonPresent() {
        return app.getUser().isElementPresent(By.xpath("//button[.='Sign Out']"));
    }


    @Test
    public void existedUserRegistrationNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setMail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }

}
