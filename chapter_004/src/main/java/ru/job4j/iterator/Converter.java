package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter Task Solution: Make convert(Iterator<Iterator>) [#152]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.05.2018
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> iterator = it.next();

            /**
             * Check next element presence in array.
             * @return presence is true, not presence is false.
             */
            @Override
            public boolean hasNext() {
                while (iterator != null) {
                    if (iterator.hasNext()) {
                        return true;
                    } else {
                        iterator = it.hasNext() ? it.next() : null;
                    }
                }
                return false;
            }

            /**
             * Get next element in array.
             * @return next element in array.
             * @throws NoSuchElementException NoSuchElementException
             */
            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}