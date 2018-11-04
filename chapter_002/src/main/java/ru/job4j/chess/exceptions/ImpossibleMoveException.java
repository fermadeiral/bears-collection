package ru.job4j.chess.exceptions;

/**
 * Class ImpossibleMoveException
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 13.01.2018
 */
public class ImpossibleMoveException extends Exception {

    /**
     * Конструктор.
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}