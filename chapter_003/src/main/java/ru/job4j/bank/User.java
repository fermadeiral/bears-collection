package ru.job4j.bank;

/**
 * User.
 * @author Ivan Belyaev
 * @since 17.01.2018
 * @version 1.0
 */
public class User {
    /** Username. */
    private String name;
    /** User's passport. */
    private String passport;

    /**
     * The constructor creates the object User.
     * @param name - username.
     * @param passport - user's passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * The method provides the user name.
     * @return returns the user name.
     */
    public String getName() {
        return name;
    }

    /**
     * The method provides the user's passport.
     * @return returns the user's passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Method compares two objects for equivalence.
     * @param o - the object with which to compare this object.
     * @return returns true if the objects are the same otherwise returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return passport.equals(user.passport);
    }

    /**
     * The method returns a hash code for this object.
     * @return returns a hash code for this object.
     */
    @Override
    public int hashCode() {
        return passport.hashCode();
    }
}
