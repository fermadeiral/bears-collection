package ru.job4j.iterators;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * MatrixIterator.
 * @author Ivan Belyaev
 * @since 26.04.2018
 * @version 1.0
 */
public class MatrixIterator implements Iterator<Integer> {
    /** Matrix. */
    private int[][] matrix;
    /** Line number. */
    private int line = 0;
    /** Column Number. */
    private int column = 0;

    /**
     * The constructor creates the object MatrixIterator.
     * @param matrix - matrix.
     */
    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * The method checks if the following element exists in the matrix.
     * @return returns true if exists otherwise returns false.
     */
    @Override
    public boolean hasNext() {
        return line < matrix.length && column < matrix[line].length;
    }

    /**
     * The method returns the next element of the matrix.
     * If the element does not exist, throws the NoSuchElementException.
     * @return returns the next element of the matrix.
     */
    @Override
    public Integer next() {
        try {
            int next = matrix[line][column++];

            if (column >= matrix[line].length) {
                column = 0;
                line++;
            }

            return next;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }
}
