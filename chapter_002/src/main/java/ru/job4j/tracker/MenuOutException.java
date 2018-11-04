package ru.job4j.tracker;

/**
 * Class MenuOutException 1. Обеспечить бесперебойную работу приложения Tracker. [#789]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 29.12.2017
 */
public class MenuOutException extends RuntimeException {

    /**
     * Конструктор.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}