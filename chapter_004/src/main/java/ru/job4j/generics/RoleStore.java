package ru.job4j.generics;

/**
 * RoleStore.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * The constructor creates the object RoleStore.
     * @param size - original size.
     */
    public RoleStore(int size) {
        super(size);
    }
}