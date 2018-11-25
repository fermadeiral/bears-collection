package ru.job4j.chess;

/**
 * ChessException.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public abstract class ChessException extends Exception {
    /**
     * The constructor creates the object ChessException.
     * @param message - message.
     */
    public ChessException(String message) {
        super(message);
    }
}
