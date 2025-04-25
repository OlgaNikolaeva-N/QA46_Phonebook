package com.phonebookHW.fw;

import com.phonebookHW.models.ContactHomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelperHomeWork extends BaseHelperHomeWork{
    public ContactHelperHomeWork(WebDriver driver) {

        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(ContactHomeWork contactHomeWork) {
        type(By.cssSelector("input:nth-child(1)"), contactHomeWork.getName());
        type(By.cssSelector("input:nth-child(2)"), contactHomeWork.getLastName());
        type(By.cssSelector("input:nth-child(3)"), contactHomeWork.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contactHomeWork.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contactHomeWork.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contactHomeWork.getDescription());
    }

    public void clickOnAddLink() {

        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
                return false;
            }

    public void deleteContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
