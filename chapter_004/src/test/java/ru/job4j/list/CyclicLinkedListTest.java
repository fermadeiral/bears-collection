package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class CyclicLinkedList | Task Solution: Find cycle in linked list [#64846]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.08.2018
 */
public class CyclicLinkedListTest {

    private CyclicLinkedList<Integer> list;
    CyclicLinkedList.Node<Integer> first;
    CyclicLinkedList.Node<Integer> second;
    CyclicLinkedList.Node<Integer> third;
    CyclicLinkedList.Node<Integer> fourth;

    @Before
    public void init() {
        list = new CyclicLinkedList<>();
        first = new CyclicLinkedList.Node<>(1);
        second = new CyclicLinkedList.Node<>(2);
        third = new CyclicLinkedList.Node<>(3);
        fourth = new CyclicLinkedList.Node<>(4);
    }

    @Test
    public void whenListHasCycleInTheEndThenTrue() {
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertThat(list.hasCycle(first), is(true));
    }

    @Test
    public void whenListHasCycleInTheMiddleThenTrue() {
        first.next = second;
        second.next = third;
        third.next = second;
        fourth.next = null;
        assertThat(list.hasCycle(first), is(true));
    }

    @Test
    public void whenListHasNoCycleThenFalse() {
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        assertThat(list.hasCycle(first), is(false));
    }

}
