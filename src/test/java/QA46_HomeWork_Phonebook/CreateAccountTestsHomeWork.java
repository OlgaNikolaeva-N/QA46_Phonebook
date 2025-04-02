package QA46_HomeWork_Phonebook;

import com.phonebookHW.models.UserHomeWork;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTestsHomeWork extends TestBaseHomeWork{

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void ensurePrecondition() {

        if (!appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnSignOutButton();
        }
    }
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){

        appHW.getUser().clickOnLoginLink();
        appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail("test_2@gmail.co").setPassword("123456$Il"));
        appHW.clickOnRegistrationButton();
        Assert.assertTrue(appHW.getUser().isSingOutButtonPresent());

    }




}
