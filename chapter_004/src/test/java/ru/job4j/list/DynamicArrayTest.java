package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * DynamicArrayTest.
 * @author Ivan Belyaev
 * @since 04.05.2018
 * @version 1.0
 */
public class DynamicArrayTest {
    /** Container. */
    private DynamicArray<Integer> list;

    /**
     * Customize tests.
     */
    @Before
    public void beforeTest() {
        list = new DynamicArray<>();
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
    @Test
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

        assertThat(list.get(10), is(11));
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
}