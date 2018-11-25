package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node.
 * @param <E> - type of value stored in Node.
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Node<E extends Comparable<E>> {
    /** Children. */
    private final List<Node<E>> children = new ArrayList<>();
    /** Value. */
    private final E value;

    /**
     * The constructor creates the object Node.
     * @param value - value.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Method adds a child to this Node.
     * @param child - new child.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * The method returns a list of children.
     * @return a list of children.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * The method compares the value with the value of this Node.
     * @param that - compared value.
     * @return true if the values are equal otherwise false.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }

    /**
     * The method returns the value of this Node.
     * @return the value of this Node.
     */
    public E getValue() {
        return value;
    }
}
