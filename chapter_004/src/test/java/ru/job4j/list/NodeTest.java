package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * NodeTest.
 * @author Ivan Belyaev
 * @since 12.05.2018
 * @version 1.0
 */
public class NodeTest {
    /**
     * Test for hasCycle method.
     * Test when an element refers to itself.
     */
    @Test
    public void whenFirstElementRefersToItselfThenHasCycleReturnsTrue() {
        Node<Integer> first = new Node<>(1);

        first.setNext(first);

        assertThat(first.hasCycle(first), is(true));
    }

    /**
     * Test for hasCycle method.
     * Test when the element refers to one of the previous.
     */
    @Test
    public void whenFourthElementRefersToFirstElementThenHasCycleReturnsTrue() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(first);

        assertThat(first.hasCycle(first), is(true));
    }

    /**
     * Test for hasCycle method.
     * Test when there is no cycling.
     */
    @Test
    public void whenNoLoopsThenHasCycleReturnsFalse() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.setNext(two);
        two.setNext(three);
        three.setNext(four);

        assertThat(first.hasCycle(first), is(false));
    }
}
