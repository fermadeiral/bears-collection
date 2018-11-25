package ru.job4j.exam;

/**
 * NotEnoughMoneyException.
 * The exception is thrown when there is insufficient amount of money.
 * @author Ivan Belyaev
 * @since 09.12.2017
 * @version 1.0
 */
public class NotEnoughMoneyException extends Exception {
    /**
     * The constructor creates the object NotEnoughMoneyException.
     * @param message - message.
     */
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
