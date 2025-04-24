package QA46_HomeWork_Phonebook;


import com.phonebook.models.Contact;
import com.phonebookHW.data.ContactDataHW;
import com.phonebookHW.data.UserDataHW;
import com.phonebookHW.models.ContactHomeWork;
import com.phonebookHW.models.UserHomeWork;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTestsHomeWork extends TestBaseHomeWork {
    @BeforeMethod
    public void precondition() {
        if (!appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnSignOutButton();
        }
        if (appHW.getUser().isLoginLinkPresent()) {
            appHW.getUser().clickOnLoginLink();
            appHW.getUser().fillRegisterLoginForm(new UserHomeWork().setMail(UserDataHW.EMAIL).setPassword(UserDataHW.PASSWORD));
            appHW.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void addContactPositiveTest() {
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName(ContactDataHW.NAME).setLastName(ContactDataHW.LASTNAME).
                setPhone(ContactDataHW.PHONE).setEmail(ContactDataHW.EMAIL).
                setAddress(ContactDataHW.ADDRESS).setDescription(ContactDataHW.DESCRIPTION));
        appHW.getContact().clickOnSaveButton();
        Assert.assertTrue(appHW.getContact().isContactAdded(ContactDataHW.NAME));
    }

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Olaf", "Li", "01234567890", "olaf@gmail.com", "Haifa", "QA"});
        list.add(new Object[]{"Olaf", "Li", "01234567899", "olaf@gmail.com", "Haifa", "QA"});
        list.add(new Object[]{"Olaf", "Li", "0123456789090", "olaf@gmail.com", "Haifa", "QA"});
        return list.iterator();

    }

    @Test(dataProvider = "addNewContact")
    public Iterator<Object[]> addContactPositiveFromDataProviderTest(String name, String lastName, String phone,
                                                                     String email, String address, String description) {
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName(name).setLastName(lastName).
                setPhone(phone).setEmail(email).
                setAddress(address).setDescription(description));
        appHW.getContact().clickOnSaveButton();
        Assert.assertTrue(appHW.getContact().isContactAdded(name));


        @DataProvider
                public Iterator<Object[]>addNewContactWithCsv() throws IOException{
            List<Object[]> list = new ArrayList<>();

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader((new File("srs/test/resources/contactsPh.csv"))));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String line = reader.readLine();

            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).
                    setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            return list.iterator();
        }
    }@Test(dataProvider = "addNewContact")
    public void addContactPositiveFromDataProviderWithCsvFileTest(String name, String lastName, String phone,
                                                       String email, String address, String description){
        appHW.getContact().clickOnAddLink();
        appHW.getContact().fillContactForm(new ContactHomeWork().setName(name).setLastName(lastName).
                setPhone(phone).setEmail(email).
                setAddress(address).setDescription(description));
        appHW.getContact().clickOnSaveButton();
        Assert.assertTrue(appHW.getContact().isContactAdded(name));
    }

    @AfterMethod
    public void postCondition(){
                appHW.getContact().deleteContact();
            }
}


