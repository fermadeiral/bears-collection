package ru.job4j.list;

/**
 * SimpleStack.
 * @param <T> - the type of the elements of this stack
 * @author Ivan Belyaev
 * @since 11.05.2018
 * @version 1.0
 */
public class SimpleStack<T> {
    /** Container for stack. */
    private SimpleLinkedList<T> stack = new SimpleLinkedList<>();

    /**
     * The method takes an item out of the stack.
     * @return returns the top element of the stack.
     */
    public T poll() {
        return stack.deleteFirst();
    }

    /**
     * The method puts the item on the stack.
     * @param value - new element.
     */
    public void push(T value) {
        stack.addFirst(value);
    }
}
