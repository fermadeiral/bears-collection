package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;

/**
 * SimpleArray.
 * @param <T> - the type of the elements of this container.
 * @author Ivan Belyaev
 * @since 01.05.2018
 * @version 1.0
 */
public class SimpleArray<T> implements Iterable<T> {
    /** Object repository. */
    private Object[] objects;
    /** Number of items in the store. */
    private int counter = 0;

    /**
     * The constructor creates the object SimpleArray.
     * @param size - storage size.
     */
    public SimpleArray(int size) {
        if (size > 0) {
            objects = new Object[size];
        } else {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
    }

    /**
     * The method returns a storage iterator.
     * @return returns a storage iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < counter;
            }

            @Override
            public T next() {
                return (T) objects[index++];
            }
        };
    }

    /**
     * The method adds an element to the container.
     * @param model - new element.
     * @return returns true if the item was added.
     */
    public boolean add(T model) {
        if (counter >= objects.length) {
            objects = Arrays.copyOf(objects, 2 * objects.length);
        }

        objects[counter++] = model;

        return true;
    }

    /**
     * The method sets the value of the element by index.
     * @param index - element index.
     * @param model - new element.
     * @return returns the replaced element.
     */
    public T set(int index, T model) {
        rangeCheck(index);

        T oldModel = (T) objects[index];
        objects[index] = model;

        return oldModel;
    }

    /**
     * The method removes the item from the container.
     * @param index - the index of the item being deleted.
     * @return returns the deleted item.
     */
    public T delete(int index) {
        rangeCheck(index);

        T oldModel = (T) objects[index];

        System.arraycopy(objects, index + 1, objects, index, counter - index - 1);
        objects[--counter] = null;

        return oldModel;
    }

    /**
     * The method returns an item from the collection.
     * @param index - the index of the desired element.
     * @return returns an item from the collection.
     */
    public T get(int index) {
        rangeCheck(index);

        return (T) objects[index];
    }

    /**
     * The method returns the size of the container.
     * @return returns the size of the container.
     */
    public int size() {
        return counter;
    }

    /**
     * The method checks whether the index leaves the container.
     * If the output throws an IndexOutOfBoundsException
     * @param index - index that is checked.
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= counter) {
            throw new IndexOutOfBoundsException();
        }
    }
}
