package QA46_HomeWork_Phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestsHomeWork extends TestBaseHomeWork{
    @Test
    public void loginPositiveTests(){
        clickOnLoginLink();
        fillRegisterLoginForm(new UserHomeWork().setMail("test_2@gmail.co").setPassword("123456$Il"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }

}
