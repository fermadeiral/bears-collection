package ru.job4j.compare;

/**
 * User.
 * @author Ivan Belyaev
 * @since 11.01.2018
 * @version 1.0
 */
public class User implements Comparable<User> {
    /** Username. */
    private String name;
    /** The age of the user. */
    private int age;

    /**
     * The constructor creates the object User.
     * @param name - username.
     * @param age - the age of the user.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * The method compares the two users according to age.
     * @param o - the user which is compared with the current.
     * @return returns -1 if the current user is less, 1 if greater, 0 if the ages are equal.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    /**
     * Method returns a string representing the object.
     * @return returns a string representing the object.
     */
    @Override
    public String toString() {
        return name + ", " + age;
    }

    /**
     * The method returns the user name.
     * @return returns the user name.
     */
    public String getName() {
        return name;
    }

    /**
     * The method returns the user's age.
     * @return returns the user's age.
     */
    public int getAge() {
        return age;
    }
}
