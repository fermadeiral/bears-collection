package ru.job4j.calculator;

/**
 * Class Calculator Решение задачи 2.3. Элементарный калькулятор [#185]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 17.10.2017
 */
public class Calculator {

    /** Результат операции. */
    private double result;

    /**
     * Метод складывает значения параметров first и second.
     * @param first Первое слагаемое
     * @param second Второе слагаемое
     */
    void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод вычитает значение параметра second от параметра first.
     * @param first Уменьшаемое
     * @param second Вычитаемое
     */
    void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод делит значение параметра first на значение параметра second.
     * @param first Делимое
     * @param second Делитель
     */
    void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод умножает значение параметра first на значение параметра second.
     * @param first Первый множитель
     * @param second Второй множитель
     */
    void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Геттер для поля result.
     * @return Значение поля result
     */
    public double getResult() {
        return this.result;
    }
}
