package ru.job4j.condition;

/**
 * Class Point Решение задачи 3.2. Положение точки [#188]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 18.10.2017
 */
public class Point {

    /** координаты точки X. */
    private int x;
    /** координаты точки Y. */
    private int y;

    /**
     * Конструктор объекта Point.
     * @param x координаты точки X
     * @param y координаты точки Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Геттер для координаты X.
     * @return Возвращает значение координаты X
     */
    public int getX() {
        return this.x;
    }

    /**
     * Геттер для координаты Y.
     * @return Возвращает значение координаты Y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Метод определяет находится ли точка Point c координатами x,y
     * на графике фукнции y(x) = a * x + b.
     * @param a значение числа a в функции y(x)
     * @param b значение числа b в функции y(x)
     * @return Возвращает true, если точка Point находится на графике фукнции y(x)
     */
    public boolean is(int a, int b) {
        return (this.y == a * this.x + b); // используя координаты точки и вычисления функции.
    }

}
