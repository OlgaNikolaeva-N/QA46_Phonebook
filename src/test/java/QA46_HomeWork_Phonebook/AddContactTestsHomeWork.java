package QA46_HomeWork_Phonebook;


import com.phonebook.models.Contact;
import com.phonebook.utils.DataProviders;
import com.phonebookHW.data.ContactDataHW;
import com.phonebookHW.data.UserDataHW;
import com.phonebookHW.models.ContactHomeWork;
import com.phonebookHW.models.UserHomeWork;
import com.phonebookHW.utilshw.DataProvidersHW;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTestsHomeWork extends TestBaseHomeWork {
    @BeforeMethod
    public void precondition() {
        if (!appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnSignOutButton();
        }
        if (appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnLoginLink();
            appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail(UserDataHW.EMAIL).setPassword(UserDataHW.PASSWORD));
            appHW.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void addContactPositiveTest() {
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName(ContactDataHW.NAME).setLastName(ContactDataHW.LASTNAME).
                setPhone(ContactDataHW.PHONE).setEmail(ContactDataHW.EMAIL).
                setAddress(ContactDataHW.ADDRESS).setDescription(ContactDataHW.DESCRIPTION));
        appHW.getContact().clickOnSaveButton();
        Assert.assertTrue(appHW.getContact().isContactAdded(ContactDataHW.NAME));
    }

    @Test(dataProvider = "addNewContact",dataProviderClass = DataProvidersHW.class)
    public Iterator<Object[]> addContactPositiveFromDataProviderTest(String name, String lastName, String phone,
                                                                     String email, String address, String description) {
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName(name).setLastName(lastName).
                setPhone(phone).setEmail(email).
                setAddress(address).setDescription(description));
        appHW.getContact().clickOnSaveButton();
        Assert.assertTrue(appHW.getContact().isContactAdded(name));
        return null;
    }


    @Test(dataProvider = "addNewContactWithCsv",dataProviderClass = DataProvidersHW.class)
    public void addContactPositiveFromDataProviderWithCsvFileTest(ContactHomeWork contact){
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(contact);
        appHW.getContact().clickOnSaveButton();
        Assert.assertTrue(appHW.getContact().isContactAdded(contact.getName()));
    }

    @AfterMethod
    public void postCondition(){
                appHW.getContact().deleteContact();
            }
}



