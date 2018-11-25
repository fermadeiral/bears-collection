package ru.job4j.chess;

/**
 * Rook.
 * @author Ivan Belyaev
 * @since 22.11.2017
 * @version 1.0
 */
public class Rook extends Figure {
    /**
     * The constructor creates the object Rook.
     * @param position - the cell in which the figure.
     */
    public Rook(Cell position) {
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

        if (diffX != 0 && diffY != 0) {
            throw new ImpossibleMoveException("The rook can not go there.");
        }

        Cell[] wayOfFigure;
        int lengthOfWay, incrementX, incrementY;
        if (diffX == 0) {
            lengthOfWay = Math.abs(diffY);
            incrementX = diffX;
            incrementY = diffY / lengthOfWay;

            wayOfFigure = new Cell[lengthOfWay];
        } else {
            lengthOfWay = Math.abs(diffX);
            incrementX = diffX / lengthOfWay;
            incrementY = diffY;

            wayOfFigure = new Cell[lengthOfWay];
        }

        x += incrementX;
        y += incrementY;
        for (int i = 0; i < wayOfFigure.length; i++, x += incrementX, y += incrementY) {
            wayOfFigure[i] = new Cell(x, y);
        }

        return wayOfFigure;
    }
}
