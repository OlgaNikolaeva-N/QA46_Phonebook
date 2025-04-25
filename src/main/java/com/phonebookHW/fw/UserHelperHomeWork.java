package com.phonebookHW.fw;

import com.phonebookHW.models.UserHomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelperHomeWork extends BaseHelperHomeWork{

    public UserHelperHomeWork(WebDriver driver) {

        super(driver);
    }

    public void clickOnRegistrationButton() {

        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(UserHomeWork userHomeWork) {
        type(By.name("email"), userHomeWork.getMail());
        type(By.name("password"), userHomeWork.getPassword());
    }

    public void clickOnLoginLink() {

        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutButtonPresent() {

        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {

        click(By.name("login"));
    }

    public boolean isErrorMessagePresent(){

        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public boolean isLoginLinkPresent() {

        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {

        click(By.xpath("//button[.='Sign Out']"));
    }


}
