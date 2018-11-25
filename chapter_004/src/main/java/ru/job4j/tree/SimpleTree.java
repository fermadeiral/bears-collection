package ru.job4j.tree;

import java.util.Optional;

/**
 * Simple tree interface.
 * @param <E> - type of items stored in the tree.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return returns true if the item was added otherwise returns false.
     */
    boolean add(E parent, E child);

    /**
     * The method searches for an element in the tree.
     * @param value - desired item.
     * @return the search result wrapped in Optional.
     */
    Optional<Node<E>> findBy(E value);
}
