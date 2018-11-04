package ru.job4j.list;

/**
 * Class SimpleArrayList Task Solution: Create method delete for simply-connected list [#51424]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 03.08.2018
 */
public class SimpleArrayList<E> {

    private int size = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    /**
     * Add element to storage.
     * @param element element.
     */
    public void add(E element) {
        Node<E> newElement;
        if (firstNode == null) {
            newElement = new Node<>(element);
            firstNode = newElement;
            lastNode = newElement;
        } else {
            newElement = new Node<>(lastNode, element);
            lastNode.next = newElement;
            lastNode = newElement;
        }
        this.size++;
    }

    /**
     * Delete first element from storage.
     * @return deleted element.
     */
    public E deleteFirst() {
        if (this.size > 0) {
            E deletingItem = this.firstNode.element;
            this.firstNode = this.firstNode.next;
            this.size--;
            return deletingItem;
        }
        return null;
    }

    /**
     * Delete last element from storage.
     * @return deleted element.
     */
    public E deleteLast() {
        if (this.size > 0) {
            E deletingItem = this.lastNode.element;
            this.lastNode = this.lastNode.prev;
            this.size--;
            return deletingItem;
        }
        return null;
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

    /**
     * Get size of storage.
     * @return number of elements in storage.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Class Node Task Solution: Create method delete for simply-connected list [#51424]
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