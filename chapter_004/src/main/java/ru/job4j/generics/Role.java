package ru.job4j.generics;

/**
 * Role.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public class Role extends Base {
    /** Role. */
    private String role;

    /**
     * The constructor creates the object Role.
     * @param role - role.
     * @param id - id.
     */
    public Role(String role, String id) {
        super(id);
        this.role = role;
    }

    /**
     * Method returns a string representation of the object.
     * @return returns a string representation of the object.
     */
    @Override
    public String toString() {
        return role;
    }
}