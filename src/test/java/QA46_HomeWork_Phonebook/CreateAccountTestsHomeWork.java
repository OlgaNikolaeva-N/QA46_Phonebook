package QA46_HomeWork_Phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTestsHomeWork extends TestBaseHomeWork{
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){

        clickOnLoginLink();
        fillRegisterLoginForm(new UserHomeWork().setMail("test_2@gmail.co").setPassword("123456$Il"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }


}
