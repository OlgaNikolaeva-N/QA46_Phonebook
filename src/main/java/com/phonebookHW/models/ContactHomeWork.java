package com.phonebookHW.models;

public class ContactHomeWork {
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String description;

    public String getName() {

        return name;
    }

    public ContactHomeWork setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {

        return lastName;
    }

    public ContactHomeWork setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {

        return phone;
    }

    public ContactHomeWork setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {

        return email;
    }

    public ContactHomeWork setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactHomeWork setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ContactHomeWork setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "ContactHomeWork{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}