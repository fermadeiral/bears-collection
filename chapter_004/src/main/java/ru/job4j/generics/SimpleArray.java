package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray Task Solution: Implement SimpleArray<T> [#156]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.05.2018
 */
class SimpleArray<T> implements Iterable<T> {

    private Object[] array;
    private int index = 0;

    /**
     * Constructor.
     */
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Add element to array.
     * @param model element.
     */
    public void add(T model) {
        this.array[index++] = model;
    }

    /**
     * Get element from array.
     * @param position position.
     * @return element.
     */
    public T get(int position) {
        return (T) this.array[position];
    }

    /**
     * Add element to array in the definite position.
     * @param position position.
     * @param model element.
     */
    public void set(int position, T model) {
        this.array[position] = model;
    }

    /**
     * Delete element from array in the definite position.
     * @param position position.
     */
    public void delete(int position) {
        this.array[position] = null;
    }

    /**
     * Get element position.
     * @param model item.
     * @return position.
     */
    public int getElementIndex(T model) {
        int position = 0;
        if (array.length > 0) {
            for (Object item : array) {
                if (item.equals(model)) {
                    return position;
                }
                position++;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int position = 0;

            /**
             * Check next element presence in array.
             * @return presence is true, not presence is false.
             */
            @Override
            public boolean hasNext() {
                return array.length > this.position;
            }

            /**
             * Get next element in array.
             * @return next element in array.
             * @throws NoSuchElementException NoSuchElementException
             */
            @Override
            public T next() throws NoSuchElementException {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[this.position++];
            }
        };
    }
}