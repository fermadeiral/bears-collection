package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator Task Solution: Make even numbers iterator [#150]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.05.2018
 */
public class EvenIterator implements Iterator {

    private final int[] numbers;
    private int index = 0;

    /**
     * Constructor.
     */
    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Check next element presence in array.
     * @return presence is true, not presence is false.
     */
    @Override
    public boolean hasNext() {
        while (index < numbers.length) {
            if ((numbers[index] % 2) == 0) {
                return true;
            }
            index++;
        }
        return false;
    }

    /**
     * Get next element in array.
     * @return next element in array.
     * @throws NoSuchElementException NoSuchElementException
     */
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}