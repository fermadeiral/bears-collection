package ru.job4j.chess.figures;

import ru.job4j.chess.*;
import ru.job4j.chess.exceptions.*;

/**
 * Class Figure Каркас шахматной доски [#792]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.01.2018
 */
abstract public class Figure {

    final Cell position;

    /**
     * Конструктор.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Метод вычисляет путь фигуры во время хода.
     * @return Массив ячеек, которые проходит фигура.
     * @param source текущая позиция фигуры
     * @param dest позиция фигуры после перемещения
     * @throws ImpossibleMoveException
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Метод Создает копию фигуры в ячейке.
     * @return Копия фигуры.
     * @param dest Ячейка, в которой будет находится копия фигуры.
     */
    public abstract Figure copy(Cell dest);
}
