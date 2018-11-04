package ru.job4j.chess.exceptions;

/**
 * Class FigureNotFoundException
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 13.01.2018
 */
public class FigureNotFoundException extends Exception {

    /**
     * Конструктор.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
