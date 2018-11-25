package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * DynamicArray.
 * @param <E> - the type of the elements of this container.
 * @author Ivan Belyaev
 * @since 04.05.2018
 * @version 1.0
 */
public class DynamicArray<E> implements Iterable<E> {
    /** Object storage. */
    private Object[] container = new Object[10];
    /** Number of items in the store. */
    private int counter = 0;
    /** Modification counter. */
    private int modCount = 0;

    /**
     * The method adds an element to the container.
     * @param value - new element.
     */
    public void add(E value) {
        if (counter == container.length) {
            container = Arrays.copyOf(container, 2 * container.length);
        }

        modCount++;

        container[counter++] = value;
    }

    /**
     * The method returns a container element.
     * @param index - the index of the desired element.
     * @return returns a container element.
     */
    public E get(int index) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException();
        }

        return (E) container[index];
    }

    /**
     * The method returns an iterator of the container.
     * @return returns an iterator of the container.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return position < counter;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return (E) container[position++];
            }
        };
    }
}