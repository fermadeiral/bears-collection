package ru.job4j.tracker;

/**
 * Interface Input Реализация ввода пользователя / тестового ввода данных
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.12.2017
 */
public interface Input {
    /**
     * Метод реализует запрос данных.
     * @param question Текст запроса.
     * @return результат запроса.
     */
    String ask(String question);

    /**
     * Метод реализует запрос данных с проверкой входящих значений.
     * @param question Текст запроса.
     * @return результат запроса.
     */
    int ask(String question, int[] range);
}
