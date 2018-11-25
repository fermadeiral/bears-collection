package ru.job4j.list;

/**
 * Node.
 * @param <T> - the type of the element with which the class works.
 * @author Ivan Belyaev
 * @since 12.05.2018
 * @version 1.0
 */
public class Node<T> {
    /** Element Value. */
    private T value;
    /** Next element. */
    private Node<T> next;

    /**
     * The constructor creates the object Node.
     * @param value - element value.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * The method sets a reference to the next element.
     * @param next - next element.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * The method checks the linked list for cyclicity.
     * @param first - the first element of the linked list.
     * @return returns true if the list is looped otherwise false.
     */
    public boolean hasCycle(Node<T> first) {
        int index = 0;
        Node<T> current = first;

        boolean result = false;

        cycle:
        while (current.next != null) {
            Node<T> temp = first;
            for (int i = 0; i <= index; i++) {
                if (current.next == temp) {
                    result = true;
                    break cycle;
                }

                temp = temp.next;
            }

            current = current.next;
            index++;
        }

        return result;
    }
}
