package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Converter.
 * @author Ivan Belyaev
 * @since 29.04.2018
 * @version 1.0
 */
public class Converter {
    /**
     * The method returns Iterator<Integer> instead of Iterator<Iterator<Integer>>.
     * @param it - Iterator<Iterator<Integer>>.
     * @return returns Iterator<Integer> instead of Iterator<Iterator<Integer>>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /** Current iterator. */
            private Iterator<Integer> currentIterator = it.next();

            /**
             * The method returns true if there are numbers in the sequence, otherwise it returns false.
             * @return returns true if there are numbers in the sequence, otherwise it returns false.
             */
            @Override
            public boolean hasNext() {
                while (!currentIterator.hasNext() && it.hasNext()) {
                    currentIterator = it.next();
                }

                return currentIterator.hasNext();
            }

            /**
             * The method returns the next element of the sequence.
             * If it does not exist, it throws NoSuchElementException
             * @return returns the next element of the sequence.
             */
            @Override
            public Integer next() {
                if (this.hasNext()) {
                    return currentIterator.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}