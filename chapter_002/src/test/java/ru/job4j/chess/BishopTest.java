package ru.job4j.chess;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BishopTest.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public class BishopTest {
    /**
     * The first test for the move method.
     */
    @Test
    public void whenMoveOneOneToFourFourThenTrue() {
        Board board = new Board();
        Cell start = new Cell(1, 1);
        Cell finish = new Cell(4, 4);
        board.setFigure(new Bishop(start), start);
        boolean methodReturns = false;
        try {
            methodReturns = board.move(start, finish);
        } catch (ChessException e) {
            e.printStackTrace();
        }
        boolean expected = true;
        assertThat(methodReturns, is(expected));
    }

    /**
     * The second test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToFourOneOneThenTrue() {
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(1, 1);
        board.setFigure(new Bishop(start), start);
        boolean methodReturns = false;
        try {
            methodReturns = board.move(start, finish);
        } catch (ChessException e) {
            e.printStackTrace();
        }
        boolean expected = true;
        assertThat(methodReturns, is(expected));
    }

    /**
     * The third test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToFourFourSixThenTrue() {
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(4, 6);
        board.setFigure(new Bishop(start), start);
        boolean methodReturns = false;
        try {
            methodReturns = board.move(start, finish);
        } catch (ChessException e) {
            e.printStackTrace();
        }
        boolean expected = true;
        assertThat(methodReturns, is(expected));
    }

    /**
     * The fourth test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToSevenThreeThenTrue() {
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(7, 3);
        board.setFigure(new Bishop(start), start);
        boolean methodReturns = false;
        try {
            methodReturns = board.move(start, finish);
        } catch (ChessException e) {
            e.printStackTrace();
        }
        boolean expected = true;
        assertThat(methodReturns, is(expected));
    }

    /**
     * The fifth test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToSevenFourThenImpossibleMoveException() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(7, 4);
        board.setFigure(new Bishop(start), start);
        try {
            board.move(start, finish);
        } catch (ChessException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                out.toString().split(System.getProperty("line.separator"))[0],
                is("The bishop can not go there.")
        );
    }

    /**
     * The sixth test for the move method.
     */
    @Test
    public void whenMoveWayIsBusyThenOccupiedWayExceptio() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Board board = new Board();
        Cell start = new Cell(3, 3);
        Cell other = new Cell(5, 5);
        Cell finish = new Cell(7, 7);
        board.setFigure(new Bishop(start), start);
        board.setFigure(new Bishop(other), other);
        try {
            board.move(start, finish);
        } catch (ChessException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                out.toString().split(System.getProperty("line.separator"))[0],
                is("Way of figure is busy.")
        );
    }

    /**
     * The seventh test for the move method.
     */
    @Test
    public void whenMoveCellDoesNotHaveFigureThenFigureNotFoundException() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Board board = new Board();
        Cell start = new Cell(3, 3);
        Cell finish = new Cell(5, 5);
        try {
            board.move(start, finish);
        } catch (ChessException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                out.toString().split(System.getProperty("line.separator"))[0],
                is("In a given cell figure not found.")
        );
    }
}
