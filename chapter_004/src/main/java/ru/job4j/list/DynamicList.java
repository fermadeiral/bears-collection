package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicList | Task Solution: Create dynamic list based on array [#158]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 03.08.2018
 */
public class DynamicList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    /**
     * Default constructor.
     */
    public DynamicList() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor.
     */
    public DynamicList(int size) {
        this.container = new Object[size];
    }

    /**
     * Add element to container.
     * @param value element.
     */
    public void add(E value) {
        if (container.length - 1 == index) {
            this.grow();
        }
        this.container[index++] = value;
    }

    /**
     * Double container capacity.
     */
    private void grow() {
        int oldCapacity = container.length;
        int newCapacity = oldCapacity * 2;
        container = Arrays.copyOf(container, newCapacity);
        modCount++;
    }

    /**
     * Get element from container.
     * @param index position.
     * @return element.
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    /**
     * Get container size.
     * @return number of elements in storage.
     */
    public int getSize() {
        return this.container.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int position = 0;
            int expectedModCount = modCount;

            /**
             * Check next element presence in container.
             * @return presence is true, not presence is false.
             */
            @Override
            public boolean hasNext() {

                return index > this.position;
            }

            /**
             * Get next element in container.
             * @return next element in container.
             * @throws NoSuchElementException NoSuchElementException
             * @throws ConcurrentModificationException ConcurrentModificationException
             */
            @Override
            public E next() throws NoSuchElementException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[this.position++];
            }
        };
    }
}