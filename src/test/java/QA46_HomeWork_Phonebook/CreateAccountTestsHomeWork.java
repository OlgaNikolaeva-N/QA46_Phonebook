package QA46_HomeWork_Phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTestsHomeWork extends TestBaseHomeWork{
    @Test
    public void newUserRegistrationPositiveTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "Test_2@gmail.co");
        //enter password
        type(By.name("password"), "123456$Il");
        //click on Registration button
        click(By.name("registration"));
        //verify SingOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }


}
