package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleLinkedListTest.
 * @author Ivan Belyaev
 * @since 10.05.2018
 * @version 1.0
 */
public class SimpleLinkedListTest {
    /** Container. */
    private SimpleLinkedList<Integer> list;

    /**
     * Customize tests.
     */
    @Before
    public void beforeTest() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Test for get method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * Iterator Testing.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThanIteratorOfThisContainer() {
        Iterator<Integer> iterator = list.iterator();

        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.next(), Is.is(1));
        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.next(), Is.is(2));
        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.next(), Is.is(3));
        assertThat(iterator.hasNext(), Is.is(false));
        iterator.next();
    }

    /**
     * Testing of automatic container increase.
     */
    @Test
    public void whenAddElementsMoreThanSizeOfContainerThanContainerIncreases() {
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        assertThat(list.get(5), is(6));
    }

    /**
     * Test with an incorrectly assigned index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void shoulThrowIndexOfBoundsException() {
        list.get(3);
    }

    /**
     * Test behavior when the collection was modified during the action of the iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        Iterator<Integer> iterator = list.iterator();
        list.add(4);
        iterator.next();
    }

    /**
     * Test for the addFirst method.
     */
    @Test
    public void whenAddFirstThenContainerContainsSuchFirstElement() {
        list.addFirst(35);
        assertThat(list.get(0), is(35));
    }

    /**
     * Test for the addLast method.
     */
    @Test
    public void whenAddLastThenContainerContainsSuchLastElement() {
        list.addLast(35);
        assertThat(list.get(list.getSize() - 1), is(35));
    }

    /**
     * Test for the deleteFirst method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirstThenRemovedFirstElementFromContainer() {
        assertThat(list.deleteFirst(), is(1));
        assertThat(list.get(0), is(2));
        assertThat(list.deleteFirst(), is(2));
        assertThat(list.get(0), is(3));
        assertThat(list.deleteFirst(), is(3));
        list.deleteFirst();
    }

    /**
     * Test for the deleteLast method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDeleteLastThenRemovedLastElementFromContainer() {
        assertThat(list.deleteLast(), is(3));
        assertThat(list.get(list.getSize() - 1), is(2));
        assertThat(list.deleteLast(), is(2));
        assertThat(list.get(list.getSize() - 1), is(1));
        assertThat(list.deleteLast(), is(1));
        list.deleteLast();
    }

    /**
     * Test for the contains method.
     */
    @Test
    public void whenContainsThenMethodReturnsTrueOnlyIfTheElementIsContainedInContainer() {
        assertThat(list.contains(3), is(true));
        assertThat(list.contains(4), is(false));

    }
}