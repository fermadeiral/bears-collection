package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MatrixIterator Task Solution: Make prime numbers iterator [#151]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 02.05.2018
 */
public class PrimeIterator implements Iterator {

    private final int[] numbers;
    private int index = 0;
    private final static int MAX_NUMBER_OF_DIVIDERS = 2;

    /**
     * Constructor.
     */
    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Check value for prime.
     * @param value value.
     * @return prime is true, not prime is false.
     */
    private boolean isPrime(int value) {
        int numberOfDividers = 0;
        for (int i = 1; i <= value; i++) {
            if ((value % i) == 0) {
                numberOfDividers++;
            }
        }
        return numberOfDividers == MAX_NUMBER_OF_DIVIDERS;
    }

    /**
     * Check next element presence in array.
     * @return presence is true, not presence is false.
     */
    @Override
    public boolean hasNext() {
        while (index < numbers.length) {
            if (isPrime(numbers[index])) {
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