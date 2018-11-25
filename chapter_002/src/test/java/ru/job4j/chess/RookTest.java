package ru.job4j.chess;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RookTest.
 * @author Ivan Belyaev
 * @since 22.11.2017
 * @version 1.0
 */
public class RookTest {
    /**
     * The first test for the move method.
     */
    @Test
    public void whenMoveFourFourToFourSixThenTrue() {
        Board board = new Board();
        Cell start = new Cell(4, 4);
        Cell finish = new Cell(4, 6);
        board.setFigure(new Rook(start), start);
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
        board.setFigure(new Rook(start), start);
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
        board.setFigure(new Rook(start), start);
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
        board.setFigure(new Rook(start), start);
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
    public void whenMoveFiveFiveToSevenSevenThenImpossibleMoveException() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Board board = new Board();
        Cell start = new Cell(5, 5);
        Cell finish = new Cell(7, 7);
        board.setFigure(new Rook(start), start);
        try {
            board.move(start, finish);
        } catch (ChessException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                out.toString().split(System.getProperty("line.separator"))[0],
                is("The rook can not go there.")
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
        Cell other = new Cell(3, 5);
        Cell finish = new Cell(3, 5);
        board.setFigure(new Rook(start), start);
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