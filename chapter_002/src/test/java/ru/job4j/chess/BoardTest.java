package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.figures.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 13.01.2018
 */
public class BoardTest {


    @Test
    public void whenFigureTriesMoveRightWayThenMoveFigure() throws
            ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(5, 3);
        board.move(source, dest);

        Figure result = board.figures[dest.getX()][dest.getY()];
        Figure expected = new Bishop(dest);
        assertThat(result, is(expected));
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveEmptyFieldThenThrowFigureNotFoundException() throws
            ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(3, 0);
        Cell dest = new Cell(5, 3);
        board.move(source, dest);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenFigureTriesMoveAndOtherFigureOnWayThenThrowOccupiedWayException() throws
            ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(2, 0);
        board.figures[3][1] = new Bishop(new Cell(3, 1));
        Cell dest = new Cell(5, 3);
        board.move(source, dest);
    }
}