package ru.job4j.chess;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * QueenTest.
 * @author Ivan Belyaev
 * @since 22.11.2017
 * @version 1.0
 */
public class QueenTest {
    /**
     * The first test for the move method.
     */
    @Test
    public void whenMoveFourFourToFourSixThenTrue() {
        Board board = new Board();
        Cell start = new Cell(4, 4);
        Cell finish = new Cell(4, 6);
        board.setFigure(new Queen(start), start);
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
    public void whenMoveFourFourToZeroFourThenTrue() {
        Board board = new Board();
        Cell start = new Cell(4, 4);
        Cell finish = new Cell(0, 4);
        board.setFigure(new Queen(start), start);
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
    public void whenMoveFourFourToFourTwoThenTrue() {
        Board board = new Board();
        Cell start = new Cell(4, 4);
        Cell finish = new Cell(4, 2);
        board.setFigure(new Queen(start), start);
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
    public void whenMoveFourFourToEightFourThenTrue() {
        Board board = new Board();
        Cell start = new Cell(4, 4);
        Cell finish = new Cell(7, 4);
        board.setFigure(new Queen(start), start);
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
    public void whenMoveOneOneToFourFourThenTrue() {
        Board board = new Board();
        Cell start = new Cell(1, 1);
        Cell finish = new Cell(4, 4);
        board.setFigure(new Queen(start), start);
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
     * The sixth test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToFourOneOneThenTrue() {
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(1, 1);
        board.setFigure(new Queen(start), start);
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
     * The seventh test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToFourFourSixThenTrue() {
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(4, 6);
        board.setFigure(new Queen(start), start);
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
     * The eighth test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToSevenThreeThenTrue() {
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(7, 3);
        board.setFigure(new Queen(start), start);
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
     * The ninth test for the move method.
     */
    @Test
    public void whenMoveFiveFiveToSevenSevenThenImpossibleMoveException() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(7, 6);
        board.setFigure(new Queen(start), start);
        try {
            board.move(start, finish);
        } catch (ChessException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                out.toString().split(System.getProperty("line.separator"))[0],
                is("The queen can not go there.")
        );
    }

    /**
     * The tenth test for the move method.
     */
    @Test
    public void whenMoveWayIsBusyThenOccupiedWayExceptio() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Board board = new Board();
        Cell start = new Cell(3, 3);
        Cell other = new Cell(3, 5);
        Cell finish = new Cell(3, 5);
        board.setFigure(new Queen(start), start);
        board.setFigure(new Knight(other), other);
        board.setFigure(new Bishop(finish), finish);
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
}