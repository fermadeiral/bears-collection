package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PrimeIterator.
 * @author Ivan Belyaev
 * @since 28.04.2018
 * @version 1.0
 */
public class PrimeIterator implements Iterator<Integer> {
    /** Array of numbers. */
    private int[] numbers;
    /** Pointer to an array. */
    private int index = 0;

    /**
     * The constructor creates the object PrimeIterator.
     * @param numbers - array of numbers.
     */
    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * The method returns true if prime numbers are still in the array, otherwise false.
     * @return returns true if prime numbers are still in the array, otherwise false.
     */
    @Override
    public boolean hasNext() {
        return getPrimeElementIndex() != -1;
    }

    /**
     * The method returns the next prime element of the array.
     * If an element does not exist, throws the NoSuchElementException.
     * @return returns the next prime element of the array.
     */
    @Override
    public Integer next() {
        int primeElementIndex = getPrimeElementIndex();

        if (primeElementIndex < 0) {
            throw new NoSuchElementException();
        }

        index = primeElementIndex + 1;

        return numbers[primeElementIndex];
    }

    /**
     * The method returns the index of the next prime element.
     * If such an element does not exist, it returns -1.
     * @return returns the index of the next prime element. If such an element does not exist, it returns -1.
     */
    private int getPrimeElementIndex() {
        int primeElementIndex = -1;

        for (int i = index; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                primeElementIndex = i;
                break;
            }
        }

        return primeElementIndex;
    }

    /**
     * The method checks whether the number is prime.
     * @param number - number.
     * @return returns true if the number is prime otherwise false.
     */
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
