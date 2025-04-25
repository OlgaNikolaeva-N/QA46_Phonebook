package com.phonebookHW.utilshw;

import com.phonebookHW.models.ContactHomeWork;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvidersHW {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Olaf", "Li", "01234567890", "olaf@gmail.com", "Haifa", "QA"});
        list.add(new Object[]{"Olaf", "Li", "01234567899", "olaf@gmail.com", "Haifa", "QA"});
        list.add(new Object[]{"Olaf", "Li", "0123456789090", "olaf@gmail.com", "Haifa", "QA"});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("srs/test/resources/contactsPh.csv")));

        String line = reader.readLine();
        while (line!=null) {

            String[] split = line.split(",");
            list.add(new Object[]{new ContactHomeWork().setName(split[0]).setLastName(split[1]).setPhone(split[2]).
                    setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
