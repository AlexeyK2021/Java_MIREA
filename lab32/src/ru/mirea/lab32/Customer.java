package ru.mirea.lab32;

public final class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;
    private Customer MATURE_UNKNOWN_CUSTOMER = null;
    private Customer NOT_MATURE_UNKNOWN_CUSTOMER = null;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
        if (age >= 18) MATURE_UNKNOWN_CUSTOMER = this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
