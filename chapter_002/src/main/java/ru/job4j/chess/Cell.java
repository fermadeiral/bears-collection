package ru.job4j.chess;

/**
 * Class Cell Описывает ячейку шахматной доски
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.01.2018
 */
public class Cell {
    private final int x;
    private final int y;

    /**
     * Конструктор.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Геттер.
     */
    public int getX() {
        return x;
    }

    /**
     * Геттер.
     */
    public int getY() {
        return y;
    }

    /**
     * Метод Проверяет эквивалентность ячеек (для тестирования).
     * @return Эквивалентность.
     * @param object Ячейка, с которой проводим сравнение.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if ((this.x == ((Cell) object).x) && (this.y == ((Cell) object).y)) {
            result = true;
        }
        return result;
    }

    /**
     * HashCode.
     * @return "unique" hashcode.
     */
    @Override
    public int hashCode() {
        return (int) (Math.random() * 10254);
    }
}
