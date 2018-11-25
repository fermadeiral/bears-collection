package ru.job4j.chess;

/**
 * FigureNotFoundException.
 * The exception is thrown when the specified cell has no figure.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public class FigureNotFoundException extends ChessException {
    /**
     * The constructor creates the object FigureNotFoundException.
     * @param message - message.
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
