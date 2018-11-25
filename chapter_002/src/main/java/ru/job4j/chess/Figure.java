package ru.job4j.chess;

/**
 * Figure.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public abstract class Figure {
    /** The cell in which the figure. */
    private final Cell position;

    /**
     * The constructor creates the object Figure.
     * @param position - the cell in which the figure.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * The method returns the path of movement of the figure.
     * @param source - the cell in which the figure.
     * @param dist - the cell in which you want to go.
     * @return returns the path of movement of the figure.
     * @throws ImpossibleMoveException - throws when a figure cannot go to the specified cell.
     */
    public abstract Cell[] way(Cell source, Cell dist) throws ImpossibleMoveException;
}
