package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){

    //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "Ol_N@gmail.com");
        //enter password
        type(By.name("password"), "Ol_111111!");
        //click on Registration button
        click(By.name("registration"));
        //verify SingOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void existedUserRegistrationNegativeTest(){

    //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "Ol_N@gmail.com");
        //enter password
        type(By.name("password"), "Ol_111111!");
        //click on Registration button
        click(By.name("registration"));
        //verify SingOut butto is displayed
        Assert.assertTrue(isAlertDisplayed());
    }


}
