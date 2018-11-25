package ru.job4j.tracker;

/**
 * UserAction.
 * @author Ivan Belyaev
 * @since 26.09.2017
 * @version 1.0
 */
public interface UserAction {
    /**
     * The method returns the number of the menu item.
     * @return - returns the number of the menu item.
     */
    int key();

    /**
     * The method performs an action selected user.
     * @param input - the input / output system.
     * @param tracker -storage applications.
     */
    void execute(Input input, Tracker tracker);

    /**
     * The method displays information about the action.
     * @return returns information about the action.
     */
    String info();
}
