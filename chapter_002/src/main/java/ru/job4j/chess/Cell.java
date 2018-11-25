package ru.job4j.chess;

/**
 * Cell.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public class Cell {
    /** The x coordinate. */
    private int x;
    /** The y coordinate. */
    private int y;

    /**
     * The constructor creates the object Cell.
     * @param x - the x coordinate.
     * @param y - the y coordinate.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The method returns the x coordinate of the cell.
     * @return returns the x coordinate of the cell.
     */
    public int getX() {
        return x;
    }

    /**
     * The method returns the y coordinate of the cell.
     * @return returns the y coordinate of the cell.
     */
    public int getY() {
        return y;
    }
}
