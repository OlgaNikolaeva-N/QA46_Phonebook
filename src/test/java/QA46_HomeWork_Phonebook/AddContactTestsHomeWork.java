package QA46_HomeWork_Phonebook;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebookHW.models.ContactHomeWork;
import com.phonebookHW.models.UserHomeWork;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTestsHomeWork extends TestBaseHomeWork {

    @BeforeMethod
    public void precondition() {
        if (!appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnSignOutButton();
        }
        if (appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnLoginLink();
            appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail("ol_n@gmail.com").setPassword("Ol_111111!"));
            appHW.getUser().clickOnLoginButton();
        }

       @Test
        public void addContactPositiveTest(){
            appHW.getContact().clickOnAddLink();
            appHW.getContact().fillContactForm(new ContactHomeWork().setName("Lera").setLastName("Bekker").setPhone("02356891470").
                    setEmail("lera_b@gmail.com").setAddress("Bat-Yam").setDescription("QA"));
            appHW.getContact().clickOnSaveButton();
            Assert.assertTrue(appHW.getContact().isContactAdded("Lera"));
        }

        @AfterMethod
        public void postCondition() {
            appHW.getContact().deleteContact();
        }

    }
}
