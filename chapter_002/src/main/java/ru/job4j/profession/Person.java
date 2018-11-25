package ru.job4j.profession;

/**
 * Person.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class Person {
    /** The field contains the name of the person. */
    private String name;

    /**
     * The constructor creates the object Person.
     * @param name - the name of the person.
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * The method returns the name of the person.
     * @return returns the name of the person.
     */
    public String getName() {
        return this.name;
    }
}
