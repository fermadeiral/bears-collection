package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 18.10.2017
 */
public class TriangleTest {

    /**
     * Test area.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Test distance.
     */
    @Test
    public void whenDistanceSetDiffPointsThen10() {
        // Создаем два объекта класса Point.
        Point left = new Point(0, 0);
        Point right = new Point(0, 10);
        // Создаем объект треугольник и в качестве точек передаем null,
        // так как нам не требуется их участие.
        Triangle triangle = new Triangle(null, null, null);

        double rsl = triangle.distance(left, right);

        assertThat(rsl, closeTo(10, 0.01));
    }

    /**
     * Test period.
     */
    @Test
    public void whenPeriodSetThreeDiffPointsThenPeriod() {
        // Создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем полупериметр.
        double result = triangle.period((triangle.distance(a, b)),
                                        (triangle.distance(a, c)),
                                        (triangle.distance(b, c)));
        // Задаем ожидаемый результат.
        double expected = 3.415D;
        // Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Test exist.
     */
    @Test
    public void whenExistSetThreeDiffPointsThenExistIsTrue() {
        // Создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем полупериметр.
        boolean result = triangle.exist((triangle.distance(a, b)),
                (triangle.distance(a, c)),
                (triangle.distance(b, c)));
        // Задаем ожидаемый результат.
        boolean expected = true;
        // Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }

    /**
     * Test exist.
     * Wrong parameters.
     */
    @Test
    public void whenCalculateAreaWithWrongParamsShouldGetIt() {
        // Создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем полупериметр.
        boolean result = triangle.exist((triangle.distance(a, b)),
                (triangle.distance(a, c)),
                (triangle.distance(b, c)));
        // Задаем ожидаемый результат.
        boolean expected = false;
        // Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}
