package ru.job4j.chess;

/**
 * Knight.
 * @author Ivan Belyaev
 * @since 22.11.2017
 * @version 1.0
 */
public class Knight extends Figure {
    /**
     * The constructor creates the object Knight.
     * @param position - the cell in which the figure.
     */
    public Knight(Cell position) {
        super(position);
    }

    /**
     * The method returns the path of movement of the figure.
     * @param source - the cell in which the figure.
     * @param dist - the cell in which you want to go.
     * @return returns the path of movement of the figure.
     * @throws ImpossibleMoveException - throws when a figure cannot go to the specified cell.
     */
    @Override
    public Cell[] way(Cell source, Cell dist) throws ImpossibleMoveException {
        int x = source.getX();
        int y = source.getY();
        int diffX = dist.getX() - x;
        int diffY = dist.getY() - y;

        Cell[] wayOfFigure;
        if ((Math.abs(diffX) == 1 && Math.abs(diffY) == 2) || (Math.abs(diffX) == 2 && Math.abs(diffY) == 1)) {
            wayOfFigure = new Cell[] {dist};
        } else {
            throw new ImpossibleMoveException("The knight can not go there.");
        }

        return wayOfFigure;
    }
}
