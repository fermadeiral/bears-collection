package ru.job4j.chess;

/**
 * King.
 * @author Ivan Belyaev
 * @since 22.11.2017
 * @version 1.0
 */
public class King extends Figure {
    /**
     * The constructor creates the object King.
     * @param position - the cell in which the figure.
     */
    public King(Cell position) {
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
        int absDiffX = Math.abs(diffX);
        int absDiffY = Math.abs(diffY);

        if (absDiffX > 1 || absDiffY > 1) {
            throw new ImpossibleMoveException("The king can not go there.");
        }

        Cell[] wayOfFigure = new Cell[1];
        int incrementX;
        int incrementY;

        if (diffX == 0) {
            incrementX = 0;
            incrementY = diffY / absDiffY;
        } else if (diffY == 0) {
            incrementX = diffX / absDiffX;
            incrementY = 0;
        } else {
            incrementX = diffX / absDiffX;
            incrementY = diffY / absDiffY;
        }

        x += incrementX;
        y += incrementY;

        wayOfFigure[0] = new Cell(x, y);

        return wayOfFigure;
    }
}