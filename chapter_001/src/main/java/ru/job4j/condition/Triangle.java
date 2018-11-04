package ru.job4j.condition;

/**
 * Class Triangle Решение задачи 3.3. Вычисление площади треугольника [#9461]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 18.10.2017
 */
public class Triangle {

    /** Первая вершина треугольника. */
    private Point a;
    /** Вторая вершина треугольника. */
    private Point b;
    /** Третья вершина треугольника. */
    private Point c;

    /**
     * Конструктор объекта Triangle.
     * @param a координаты точки a
     * @param b координаты точки b
     * @param c координаты точки c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисляет расстояние между точками left и right.
     * @param left Точка слева
     * @param right Точка справа
     * @return расстояние между точками left и right.
     */
    public double distance(Point left, Point right) {
        return (Math.sqrt(((right.getX() - left.getX()) * (right.getX() - left.getX()))
                + ((right.getY() - left.getY()) * (right.getY() - left.getY()))));
    }

    /**
     * Метод вычисляет полупериметр по длинам сторон.
     *
     * @param ab расстояние между точками a и b
     * @param ac расстояние между точками a и c
     * @param bc расстояние между точками b и c
     * @return полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return ((ab + ac + bc) / 2);
    }

    /**
     * Метод вычисляет прощадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a до точки b.
     * @param ac Длина от точки a до точки c.
     * @param bc Длина от точки b до точки c.
     * @return возвращает true, если треугольник существует
     */
    protected boolean exist(double ab, double ac, double bc) {
        return (ab > 0 && ac > 0 && bc > 0
                && ((ab + bc) > ac)
                && ((ab + ac) > bc)
                && ((bc + ac) > ab));
    }
}
