package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Vera").setLastName("Levi").setPhone("2356891470").
                setEmail("vera_L@gmail.com").setAddress("Holon").setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Vera"));


    }

    @AfterMethod
    public void postCondition(){

        app.getContact().deleteContact();
    }

}