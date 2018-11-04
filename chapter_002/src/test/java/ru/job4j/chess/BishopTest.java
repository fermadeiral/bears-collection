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
public class BishopTest {

    @Test
    public void whenSetSourceAndSetDestThenReturnWayCells() throws ImpossibleMoveException {
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(5, 3);
        Figure bishop = new Bishop(source);

        Cell[] result = {new Cell(3, 1), new Cell(4, 2), new Cell(5, 3)};
        Cell[] expected = bishop.way(source, dest);
        assertThat(result, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenSetSourceAndSetWrongDestThenThrowImpossibleMoveException() throws ImpossibleMoveException {
        Cell source = new Cell(2, 0);
        Cell dest = new Cell(6, 3);
        Figure bishop = new Bishop(source);

        bishop.way(source, dest);
    }
}