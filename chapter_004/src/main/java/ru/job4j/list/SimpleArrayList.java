package ru.job4j.list;

/**
 * SimpleArrayList.
 * @param <E> - the type of the elements of this container
 * @author Ivan Belyaev
 * @since 03.05.2018
 * @version 1.0
 */
public class SimpleArrayList<E> {
    /** Current container size. */
    private int size;
    /** The first element of the container. */
    private Node<E> first;

    /**
     * The method adds an element to the container.
     * @param data - data to be added.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method removes an item from the container.
     * @return returns a deleted item.
     */
    public E delete() {
        E result = first.data;

        first = first.next;
        size--;

        return result;
    }

    /**
     * The method returns an item from the container.
     * @param index - the index of the desired element.
     * @return returns an item from the container.
     */
    public E get(int index) {
        Node<E> result = this.first;

        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.data;
    }

    /**
     * The method returns the current size of the container.
     * @return returns the current size of the container.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Class storage container element.
     * @param <E> - type parameter
     */
    private static class Node<E> {
        /** Data that is stored in the container. */
        private E data;
        /** Link to the next item. */
        private Node<E> next;

        /**
         * The constructor creates the object Node.
         * @param data - data that is stored in the container.
         */
        Node(E data) {
            this.data = data;
        }
    }
}
