package ru.job4j.generics;

/**
 * User.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public class User extends Base {
    /** Username. */
    private String name;

    /**
     * The constructor creates the object User.
     * @param name - username.
     * @param id - id.
     */
    public User(String name, String id) {
        super(id);
        this.name = name;
    }

    /**
     * Method returns a string representation of the object.
     * @return returns a string representation of the object.
     */
    @Override
    public String toString() {
        return name;
    }
}