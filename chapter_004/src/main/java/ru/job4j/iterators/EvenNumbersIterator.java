package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenNumbersIterator.
 * @author Ivan Belyaev
 * @since 28.04.2018
 * @version 1.0
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    /** Array of numbers. */
    private int[] numbers;
    /** Pointer to an array. */
    private int index = 0;

    /**
     * The constructor creates the object EvenNumbersIterator.
     * @param numbers - array of numbers.
     */
    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * The method returns true if even numbers are still in the array, otherwise false.
     * @return returns true if even numbers are still in the array, otherwise false.
     */
    @Override
    public boolean hasNext() {
        return getEvenElementIndex() != -1;
    }

    /**
     * The method returns the next even element of the array.
     * If an element does not exist, throws the NoSuchElementException.
     * @return returns the next even element of the array.
     */
    @Override
    public Integer next() {
        int evenElementIndex = getEvenElementIndex();

        if (evenElementIndex < 0) {
            throw new NoSuchElementException();
        }

        index = evenElementIndex + 1;

        return numbers[evenElementIndex];
    }

    /**
     * The method returns the index of the next even element.
     * If such an element does not exist, it returns -1.
     * @return returns the index of the next even element. If such an element does not exist, it returns -1.
     */
    private int getEvenElementIndex() {
        int evenElementIndex = -1;

        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenElementIndex = i;
                break;
            }
        }

        return evenElementIndex;
    }
}
