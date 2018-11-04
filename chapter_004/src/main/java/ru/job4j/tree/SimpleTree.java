package ru.job4j.tree;

import java.util.Optional;

/**
 * Interface ownTree | Task Solution: Make simple tree structure [#1711]
 * @author @author Petr Arsentev (parsentev@yandex.ru)
 * @since 0.1
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> { //todo !!!!! extends Iterable<E>
    /**
     * Add child element in parent.
     * @param parent parent.
     * @param child child.
     * @return true if child element adds.
     */
    boolean add(E parent, E child);

    /**
     * Find Node in tree by its value.
     * @param value value.
     * @return Node
     */
    Optional<Node<E>> findBy(E value);
}
