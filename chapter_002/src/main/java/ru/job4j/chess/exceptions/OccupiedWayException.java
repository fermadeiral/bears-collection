package ru.job4j.chess.exceptions;

/**
 * Class OccupiedWayException
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 13.01.2018
 */
public class OccupiedWayException extends Exception {

    /**
     * Конструктор.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}