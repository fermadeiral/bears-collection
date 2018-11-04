package ru.job4j.list;

import java.util.*;

/**
 * Class DynamicLinkedList | Task Solution: Create container based on linked list
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 03.08.2018
 */
public class DynamicLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    /**
     * Add element to storage.
     * @param value element.
     */
    public void add(E value) {
        Node<E> newElement;
        if (firstNode == null) {
            newElement = new Node<>(value);
            firstNode = newElement;
            lastNode = newElement;
        } else {
            newElement = new Node<>(lastNode, value);
            lastNode.next = newElement;
            lastNode = newElement;
        }
        modCount++;
        this.size++;
    }

    /**
     * Get element from storage by index.
     * @param index index.
     * @return element.
     */
    public E get(int index) {
        Node<E> result = this.firstNode;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.element;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int position = 0;
            int expectedModCount = modCount;
            /**
             * Check next element presence in storage.
             * @return presence is true, not presence is false.
             */
            @Override
            public boolean hasNext() {
                return size > this.position;
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
                return get(this.position++);
            }
        };
    }

    /**
     * Class Node | Task Solution: Create container based on linked list
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 03.08.2018
     */
    private static class Node<E> {
        Node<E> next;
        Node<E> prev;
        private final E element;
        /**
         * Constructor.
         */
        Node(Node<E> prev, E element) {
            this.prev = prev;
            this.element = element;
        }

        /**
         * Constructor.
         */
        Node(E element) {
            this.element = element;
        }
    }
}