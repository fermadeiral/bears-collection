package ru.job4j.loop;

/**
 * Class Counter 4.1. Подсчет суммы чётных чисел в диапазоне [#192]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.10.2017
 */
public class Counter {

    /**
     * Метод подсчета суммы чётных чисел в заданном диапазоне.
     * @param start Левая граница диапазона
     * @param finish Правая граница диапазона
     * @return сумма.
     */
    public int add(int start, int finish) {
        /** Результат подсчета. */
        int result = 0;

        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
