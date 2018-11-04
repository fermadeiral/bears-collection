package ru.job4j.chess;

import ru.job4j.chess.figures.*;
import ru.job4j.chess.exceptions.*;

/**
 * Class Board Реализация шахматной доски.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.01.2018
 */
public class Board {
    Figure[][] figures = new Figure[8][8];

    /**
     * Метод заполняет шахматною доску фигурами согласно правилам шахмат.
     * На данном этапе на доску ставятся только слоны.
     */
    void fillBoard() {
        figures[2][0] = new Bishop(new Cell(2, 0));
        figures[5][0] = new Bishop(new Cell(5, 0));
        figures[2][7] = new Bishop(new Cell(2, 7));
        figures[5][7] = new Bishop(new Cell(5, 7));
    }

    /**
     * Конструктор.
     */
    public Board() {
        fillBoard();
    }

    /**
     * Метод реализует ход фигуры.
     * @return Успешность хода.
     * @param source текущая позиция фигуры
     * @param dest позиция фигуры после перемещения
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell source, Cell dest)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean result = false;
        Figure figure = figures[source.getX()][source.getY()];
        if (figure != null) {
            Cell[] cells = figure.way(source, dest);
            // проверяем ячейки, по которым пойдет фигура
            for (Cell cell : cells) {
                if (figures[cell.getX()][cell.getY()] != null) {
                    throw new OccupiedWayException(
                            String.format("Ход невозможен: на пути находится фигура в ячейке \"%d %d\".",
                                            cell.getX(), cell.getY()));
                }
            }
            // копируем фигуру в новую позицию
            figures[dest.getX()][dest.getY()] = figure.copy(dest);
            // удаляем фигуру из начальной позиции
            figures[source.getX()][source.getY()] = null;

            result = true;
        } else {
            throw new FigureNotFoundException(
                    String.format("Ячейка \"%d %d\" пустая.", source.getX(), source.getY()));
        }
        return result;
    }
}