package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator Task Solution: Iterator for two-dimensional array [#51331]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 29.04.2018
 */
public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int row = 0;
    private int column = 0;

    /**
     * Constructor.
     */
    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    /**
     * Check next element presence in array.
     * @return presence is true, not presence is false
     */
    @Override
    public boolean hasNext() {
        return row != values.length;
    }

    /**
     * Get next element in array.
     * @return next element in array
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }

        int result = values[row][column++];
        if (values[row].length <= column) {
            row++;
            column = 0;
        }
        return result;
    }
}