package ru.job4j.chess;

/**
 * ImpossibleMoveException.
 * The exception is thrown when a figure cannot go to the specified cell.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public class ImpossibleMoveException extends ChessException {
    /**
     * The constructor creates the object ImpossibleMoveException.
     * @param message - message.
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
