package ru.job4j.convert;

/**
 * User.
 * @author Ivan Belyaev
 * @since 10.01.2018
 * @version 1.0
 */
public class User {
    /** Unique identifier. */
    private int id;
    /** The student's name. */
    private String name;
    /** City. */
    private String city;

    /**
     * The constructor creates the object User.
     * @param id - unique identifier.
     * @param name - the student's name.
     * @param city - city.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * The method returns the user id.
     * @return returns the user id.
     */
    public int getId() {
        return id;
    }

    /**
     * The method returns the user name.
     * @return returns the user name.
     */
    public String getName() {
        return name;
    }

    /**
     * The method returns the user city.
     * @return returns the user city.
     */
    public String getCity() {
        return city;
    }
}
