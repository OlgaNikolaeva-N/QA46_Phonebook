package QA46_HomeWork_Phonebook;

import com.phonebookHW.data.ContactDataHW;
import com.phonebookHW.data.UserDataHW;
import com.phonebookHW.models.ContactHomeWork;
import com.phonebookHW.models.UserHomeWork;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTestsHomeWork extends TestBaseHomeWork{
    @BeforeMethod
    public void precondition(){
        if(!appHW.getUser().isLoginLinkPresent()){
            appHW.getUser().clickOnSignOutButton();
        }
        appHW.getUser().clickOnLoginLink();
        appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail(UserDataHW.EMAIL).setPassword(UserDataHW.PASSWORD));
        appHW.getUser().clickOnLoginButton();
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName(ContactDataHW.NAME).setLastName(ContactDataHW.LASTNAME).
                setPhone(ContactDataHW.PHONE).setEmail(ContactDataHW.EMAIL).
                setAddress(ContactDataHW.ADDRESS).setDescription(ContactDataHW.DESCRIPTION));
        appHW.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = appHW.getContact().sizeOfContacts();
        appHW.getContact().deleteContact();
        appHW.getContact().pause(1000);
        int sizeAfter = appHW.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }


}
