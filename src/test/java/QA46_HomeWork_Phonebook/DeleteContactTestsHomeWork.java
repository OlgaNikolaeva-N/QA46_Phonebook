package QA46_HomeWork_Phonebook;

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
        appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail("ol_n1@gmail.com").setPassword("Ol_111111!"));
        appHW.getUser().clickOnLoginButton();
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName("Lera").setLastName("Bekker").setPhone("0123456789").
                setEmail("lera@gmail.com").setAddress("Haifa").setDescription("QA"));
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
