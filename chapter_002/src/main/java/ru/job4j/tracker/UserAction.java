package ru.job4j.tracker;

/**
 * Interface UserAction Реализация действий пользователя
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 25.12.2017
 */
public interface UserAction {

    /**
     * Метод идентифицирует соответствие действия определенному пункту меню.
     * @return Порядковый номер.
     */
    int key();

    /**
     * Метод выполняет действие, выбранное пользователем.
     * @param input Способ ввода данных.
     * @param tracker Экземпляр хранилища заявокю
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод формирует порядковый номер и описание действия в меню пользователя.
     * @return Порядковый номер и описание действия.
     */
    String info();
}