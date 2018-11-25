package ru.job4j.set;

import ru.job4j.list.DynamicArray;

import java.util.Iterator;

/**
 * SimpleSet.
 * @param <E> - the type of the elements of this container.
 * @author Ivan Belyaev
 * @since 13.05.2018
 * @version 1.0
 */
public class SimpleSet<E> implements Iterable<E> {
    /** Internal container for the content of items. */
    private DynamicArray<E> set = new DynamicArray<>();

    /**
     * The method adds an element to the container.
     * Add only those items that are not in the container.
     * @param value - new element.
     */
    public void add(E value) {
        boolean hasElement = false;

        for (E elem : set) {
            if (value.equals(elem)) {
                hasElement = true;
                break;
            }
        }

        if (!hasElement) {
            set.add(value);
        }
    }

    /**
     * The method returns an iterator of the container.
     * @return returns an iterator of the container.
     */
    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}
