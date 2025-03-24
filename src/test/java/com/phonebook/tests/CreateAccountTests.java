package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        clickOnLoginLink();
        fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSingOutButtonPresent());
    }

    public boolean isSingOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }


    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}
