package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

import java.util.Iterator;

/**
 * SimpleSet.
 * @param <E> - the type of the elements of this container.
 * @author Ivan Belyaev
 * @since 14.05.2018
 * @version 1.0
 */
public class SimpleSetOnLinkedList<E> implements Iterable<E> {
    /** Internal container for the content of items. */
    private SimpleLinkedList<E> set = new SimpleLinkedList<>();

    /**
     * The method adds an element to the container.
     * Add only those items that are not in the container.
     * @param value - new element.
     */
    public void add(E value) {
        if (!set.contains(value)) {
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
