package ru.job4j.list;

/**
 * Class CyclicLinkedList | Task Solution: Find cycle in linked list [#64846]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.08.2018
 */
public class CyclicLinkedList<T> {

    /**
     * Check list for cyclicity.
     * @param first first element of list.
     * @return true if list has cycle.
     */
    boolean hasCycle(Node<T> first) {
        Boolean result = false;
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
     }

    /**
     * Class Node | Task Solution: Find cycle in linked list [#64846]
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 05.08.2018
     */
     static class Node<T> {
        T value;
        Node<T> next;

        /**
         * Constructor.
         */
        Node(T value) {
            this.value = value;
        }
    }
}