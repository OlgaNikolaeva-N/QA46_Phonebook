package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){

        clickOnLoginLink();
        fillregisterloginform(new User().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact().setLastName("Vera").setLastName("Levi").setPhone("2356891470").
                setEmail("vera_L@gmail.com").setAddress("Holon").setDescription("QA"));
        clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

}
