package ru.job4j;

/**
 * Class Calculate Решение задачи 1.1. Создание Hello World [#141]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 13.10.2017
 */

class Calculate {
    /**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }

    /**
     * Метод для запуска программы.
     * @param args аргументы программы
     */
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}