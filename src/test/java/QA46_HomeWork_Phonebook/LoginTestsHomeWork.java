package QA46_HomeWork_Phonebook;

import com.phonebookHW.models.UserHomeWork;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsHomeWork extends TestBaseHomeWork{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!appHW.getUser().isLoginLinkPresent()){
            appHW.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTests(){
        appHW.clickOnLoginLink();
        appHW.fillRegisterLoginForm(new UserHomeWork().setMail("test_2@gmail.co").setPassword("123456$Il"));
        appHW.clickOnLoginButton();
        Assert.assertTrue(appHW.getUser().isSingOutButtonPresent());

    }

}
