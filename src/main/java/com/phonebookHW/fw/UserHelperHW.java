package com.phonebookHW.fw;

import com.phonebook.models.User;
import com.phonebookHW.models.UserHomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelperHW extends BaseHelperHW{
    public UserHelperHW(WebDriver driver) {

        super(driver);
    }
    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(UserHomeWork user) {
        type(By.name("email"), user.getMail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {

        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {

        click(By.name("login"));
    }

    public boolean isErrorMessagePresent() {

        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }
    public boolean isSingOutButtonPresent() {

        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isLoginLinkPresent() {

        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {

        click(By.xpath("//button[.='Sign Out']"));
    }
}
