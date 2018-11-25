package ru.job4j.list;

/**
 * SimpleQueue.
 * @param <T> - the type of the elements of this queue
 * @author Ivan Belyaev
 * @since 11.05.2018
 * @version 1.0
 */
public class SimpleQueue<T> {
    /** Container for queue. */
    private SimpleLinkedList<T> queue = new SimpleLinkedList<>();

    /**
     * The method takes the element out of the queue.
     * @return returns the first element of the queue.
     */
    public T poll() {
        return queue.deleteLast();
    }

    /**
     * The method puts the element in the queue.
     * @param value - new element.
     */
    public void push(T value) {
        queue.addFirst(value);
    }
}
