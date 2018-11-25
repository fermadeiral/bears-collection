package ru.job4j.search;

/**
 * Person.
 * @author Ivan Belyaev
 * @since 24.04.2018
 * @version 1.0
 */
public class Person {
    /** Name of the person. */
    private String name;
    /** Surname of the person. */
    private String surname;
    /** Phone number. */
    private String phone;
    /** Address. */
    private String address;

    /**
     * The constructor creates the object Person.
     * @param name - name of the person.
     * @param surname - surname of the person.
     * @param phone - phone number.
     * @param address - address.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Method returns the name of the person.
     * @return returns the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns the surname of the person.
     * @return returns the surname of the person.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * The method returns the phone number of the person.
     * @return returns the phone number of the person.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * The method returns the address of the person.
     * @return returns the address of the person.
     */
    public String getAddress() {
        return address;
    }
}