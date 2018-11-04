package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Class DynamicLinkedListTest | Task Solution: Create container based on linked list
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 03.08.2018
 */
public class DynamicLinkedListTest {

    DynamicLinkedList<Integer> list = new DynamicLinkedList<>();

    @Test
    public void whenAddIntegerValueThenGetValue() {
        list.add(15);
        assertThat(list.get(0), is(15));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        list.add(15);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowConcurrentModificationException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(15);
        iterator.next();
    }
}