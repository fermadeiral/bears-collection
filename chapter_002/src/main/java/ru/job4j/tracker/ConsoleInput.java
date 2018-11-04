package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput Реализация ввода пользователя
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.12.2017
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод реализует запрос данных от пользователя.
     * @param question Текст запроса.
     * @return результат запроса.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод реализует запрос данных от пользователя с проверкой.
     * @param question Текст запроса.
     * @param range Диапазон корректных значений для выбора в меню
     * @return результат запроса.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;

        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of range.");
        }
    }
}
