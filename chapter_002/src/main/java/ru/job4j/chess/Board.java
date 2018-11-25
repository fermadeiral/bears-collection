package ru.job4j.chess;

/**
 * Board.
 * @author Ivan Belyaev
 * @since 16.11.2017
 * @version 1.0
 */
public class Board {
    /** Array of figures mimics a chess Board. */
    private Figure[][] figures = new Figure[8][8];



    /**
     * The method moves the figure.
     * @param source - the cell from which you want to move the figure.
     * @param dist - the cell in which you want to move the figure.
     * @return returns true if move succeeded.
     * @throws ImpossibleMoveException - throws when a figure cannot go to the specified cell.
     * @throws OccupiedWayException - throws when the path is busy figures.
     * @throws FigureNotFoundException - throws when the specified cell has no figure.
     */
    public boolean move(Cell source, Cell dist)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        if (figures[source.getX()][source.getY()] == null) {
            throw new FigureNotFoundException("In a given cell figure not found.");
        }

        Cell[] wayOfFigure = figures[source.getX()][source.getY()].way(source, dist);

        for (Cell cell : wayOfFigure) {
            if (figures[cell.getX()][cell.getY()] != null) {
                throw new OccupiedWayException("Way of figure is busy.");
            }
        }

        figures[dist.getX()][dist.getY()] = figures[source.getX()][source.getY()];
        figures[source.getX()][source.getY()] = null;

        return true;
    }

    /**
     * The method puts a figure on the chessboard.
     * @param figure - chess figure.
     * @param cell - the cell in which you want to pose the figure.
     */
    public void setFigure(Figure figure, Cell cell) {
        figures[cell.getX()][cell.getY()] = figure;
    }
}
