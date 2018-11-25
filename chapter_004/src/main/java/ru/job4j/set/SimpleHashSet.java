package ru.job4j.set;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * SimpleHashSet.
 * @param <E> - the type of the elements of this container.
 * @author Ivan Belyaev
 * @since 31.05.2018
 * @version 1.0
 */
public class SimpleHashSet<E> implements Iterable<E> {
    /** Object storage. */
    private Object[] container = new Object[16];
    /** Number of items in the store. */
    private int size = 0;
    /** Storage size. */
    private int containerSize = 16;
    /** Modification counter. */
    private int modCount = 0;

    /**
     * The method adds an element to the container.
     * @param value - new element.
     * @return returns true if an element is added.
     */
    public boolean add(E value) {
        int index = value.hashCode() % containerSize;
        if (container[index] == null) {
            size++;
        }
        container[index] = value;

        if (size > 0.75 * containerSize) {
            containerSize = containerSize * 2;
            container = Arrays.copyOf(container, containerSize);
        }
        modCount++;
        return true;
    }

    /**
     * The method checks whether the element is contained in the container.
     * @param value -checked item.
     * @return returns true if the element is contained in the container, otherwise it returns false.
     */
    public boolean contains(E value) {
        int index = value.hashCode() % containerSize;
        return container[index] != null;
    }

    /**
     * The method takes out the last element of the container.
     * @param value - deleted item.
     * @return returns true if the container contained this element.
     */
    public boolean remove(E value) {
        boolean result = false;

        if (contains(value)) {
            int index = value.hashCode() % containerSize;
            container[index] = null;
            size--;
            modCount++;
        }

        return result;
    }

    /**
     * The method returns the size of the container.
     * @return returns the size of the container.
     */
    public int size() {
        return size;
    }

    /**
     * The method returns an iterator of the container.
     * @return returns an iterator of the container.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int counter = 0;
            private int expectedModCount = modCount;
            private int position = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                for ( ; position < container.length; position++) {
                    if (container[position] != null) {
                        counter++;
                        break;
                    }
                }

                return (E) container[position++];
            }
        };
    }
}
