package ru.job4j.chess.figures;

import ru.job4j.chess.*;
import ru.job4j.chess.exceptions.*;

/**
 * Class Bishop Реализация фигуры "Слон".
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.01.2018
 */
public class Bishop extends Figure {

    /**
     * Конструктор.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Метод вычисляет путь фигуры во время хода.
     * @return Массив ячеек, которые проходит фигура.
     * @param source текущая позиция фигуры
     * @param dest позиция фигуры после перемещения
     * @throws ImpossibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {

        // вычисляем количество ячеек, которое должна пройти фигура
        int distance = dest.getX() - source.getX();
        Cell[] cells = new Cell[Math.abs(distance)];

        if ((Math.abs(dest.getX() - source.getX()) != Math.abs(dest.getY() - source.getY())) || distance == 0) {
            throw new ImpossibleMoveException(String.format(
                    "Ход на ячейку \"%d %d\" невозможен.", dest.getX(), dest.getY()));
        }

        // вычисляем номера ячеек
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i < cells.length; i++) {

            if (dest.getX() > source.getX()) {
                x++;
            } else {
                x--;
            }

            if (dest.getY() > source.getY()) {
                y++;
            } else {
                y--;
            }
            cells[i] = new Cell(x, y);
        }
        return cells;
    }

    /**
     * Метод Создает копию фигуры в ячейке.
     * @return Копия фигуры.
     * @param dest Ячейка, в которой будет находится копия фигуры.
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    /**
     * Метод Проверяет эквивалентность фигур (для тестирования).
     * @return Эквивалентность.
     * @param object Фигура, с которой проводим сравнение.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if ((object.getClass() == this.getClass()) && (position.equals(((Bishop) object).position))) {
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