package QA46_HomeWork_Phonebook;


import com.phonebookHW.models.UserHomeWork;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTestsHomeWork extends TestBaseHomeWork{

    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void ensurePrecondition(){
        if(!appHW.getUser().isLoginLinkPresent()){
            appHW.getUser().clickOnSignOutButton();
        }
    }
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        //int i = (int)((System.currentTimeMillis()/1000)%3600);
        appHW.getUser().clickOnLoginLink();
        appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail("ol_n1@gmail.com").setPassword("Ol_111111!"));
        appHW.getUser().clickOnRegistrationButton();
        //Assert.assertTrue(isAlertDisplayed());
        Assert.assertTrue(appHW.getUser().isSignOutButtonPresent());
    }

}
