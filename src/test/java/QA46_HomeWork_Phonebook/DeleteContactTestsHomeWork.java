package QA46_HomeWork_Phonebook;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebookHW.models.ContactHomeWork;
import com.phonebookHW.models.UserHomeWork;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTestsHomeWork extends TestBaseHomeWork{

    @BeforeMethod
    public void precondition(){

        appHW.getUser().clickOnLoginLink();
        appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
        appHW.getUser().clickOnLoginButton();
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName("Lera").setLastName("Bekker").setPhone("02356891470").
                setEmail("lera_B@gmail.com").setAddress("Bat-Yam").setDescription("QA"));
        appHW.getContact().clickOnSaveButton();


    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = appHW.getContact().sizeOfContacts();
        appHW.getContact().deleteContact();
        appHW.getContact().pause(1000);
        int sizeAfter = appHW.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }
}
