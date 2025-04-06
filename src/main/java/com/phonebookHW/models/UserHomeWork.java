package com.phonebookHW.models;

public class UserHomeWork {
    private String mail;
    private String password;

    public UserHomeWork setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public UserHomeWork setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}