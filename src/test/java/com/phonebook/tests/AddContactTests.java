package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        clickOnAddLink();
        fillContactForm(new Contact().setLastName("Vera").setLastName("Levi").setPhone("2356891470").
                setEmail("vera_L@gmail.com").setAddress("Holon").setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("Vera"));

    }

    @AfterMethod
    public void postCondition(){
        deleteContact();
    }

}