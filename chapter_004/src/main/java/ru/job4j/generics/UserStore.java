package ru.job4j.generics;

/**
 * UserStore.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public class UserStore extends AbstractStore<User> {
    /**
     * The constructor creates the object UserStore.
     * @param size - original size.
     */
    public UserStore(int size) {
        super(size);
    }
}