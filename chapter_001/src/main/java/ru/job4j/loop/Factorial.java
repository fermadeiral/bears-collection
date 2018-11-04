package ru.job4j.loop;

/**
 * Class Factorial 4.2. Создать программу вычисляющую факториал.[#193]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.10.2017
 */
public class Factorial {

    /**
     * Метод подсчета факториала числа.
     * @param n Заданное число.
     * @return Факториал числа.
     */
    int calc(int n) {
        /** Результат подсчета. */
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
