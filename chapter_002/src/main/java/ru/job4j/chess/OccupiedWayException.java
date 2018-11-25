package ru.job4j.chess;

/**
 * OccupiedWayException.
 * The exception is thrown when the path is busy figures.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public class OccupiedWayException extends ChessException {
    /**
     * The constructor creates the object OccupiedWayException.
     * @param message - message.
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
