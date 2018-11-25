package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleLinkedList.
 * @param <E> - the type of the elements of this container
 * @author Ivan Belyaev
 * @since 10.05.2018
 * @version 1.0
 */
public class SimpleLinkedList<E> implements Iterable<E> {
    /** The first element of the container. */
    private Node first;
    /** The last element of the container. */
    private Node last;
    /** The size of the container. */
    private int size;
    /** Modification counter. */
    private int modCount;

    /**
     * The method adds an element to the container.
     * @param value - new element.
     */
    public void add(E value) {
        Node newLink = new Node(value);

        if (first == null) {
            first = newLink;
        } else {
            newLink.prev = last;
            last.next = newLink;
        }

        last = newLink;
        size++;
        modCount++;
    }

    /**
     * The method adds an element to the beginning of the container.
     * @param value - new element.
     */
    public void addFirst(E value) {
        Node newLink = new Node(value);

        if (first == null) {
            last = newLink;
        } else {
            newLink.next = first;
            first.prev = newLink;
        }

        first = newLink;
        size++;
        modCount++;
    }

    /**
     * The method adds an element to the end of the container.
     * @param value - new element.
     */
    public void addLast(E value) {
        add(value);
    }

    /**
     * The method returns a container element.
     * @param index - the index of the desired element.
     * @return returns a container element.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node result;

        if (index < size / 2) {
            result = first;

            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = last;

            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
        }

        return result.data;
    }

    /**
     * The method takes the first element out of the container.
     * @return returns the first element of the container.
     */
    public E deleteFirst() {
        Node elem = first;

        if (elem == null) {
            throw new NoSuchElementException();
        }

        first = first.next;

        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }

        size--;
        modCount++;

        return elem.data;
    }

    /**
     * The method takes out the last element of the container.
     * @return returns the last element of the container.
     */
    public E deleteLast() {
        Node elem = last;

        if (elem == null) {
            throw new NoSuchElementException();
        }

        last = last.prev;

        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }

        size--;
        modCount++;

        return elem.data;
    }

    /**
     * The method returns the size of the container.
     * @return returns the size of the container.
     */
    public int getSize() {
        return size;
    }

    /**
     * The method checks whether the element is contained in the container.
     * @param value -checked item.
     * @return returns true if the element is contained in the container, otherwise it returns false.
     */
    public boolean contains(E value) {
        boolean result = false;

        Iterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            if (value.equals(iterator.next())) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * The method returns an iterator of the container.
     * @return returns an iterator of the container.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = first;
            private int position = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                if (current == null) {
                    throw new NoSuchElementException();
                }

                Node result = current;

                if (hasNext()) {
                    current = current.next;
                } else {
                    current = null;
                }

                position++;

                return result.data;
            }
        };
    }

    /**
     * Class storage container element.
     */
    private class Node {
        /** Data that is stored in the container. */
        private E data;
        /** Link to the next item. */
        private Node next;
        /** Link to the previous item. */
        private Node prev;

        /**
         * The constructor creates the object Node.
         * @param data - data that is stored in the container.
         */
        Node(E data) {
            this.data = data;
        }
    }
}
