package QA46_HomeWork_Phonebook;

import com.phonebookHW.data.UserDataHW;
import com.phonebookHW.models.UserHomeWork;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsHomeWork extends TestBaseHomeWork{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!appHW.getUser().isLoginLinkPresent()){
            appHW.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTests(){
        appHW.getUser().clickOnLoginLink();
        appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail(UserDataHW.EMAIL).setPassword(UserDataHW.PASSWORD));
        appHW.getUser().clickOnLoginButton();
        Assert.assertTrue(appHW.getUser().isSignOutButtonPresent());
    }
}
