package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleArrayTest.
 * @author Ivan Belyaev
 * @since 01.05.2018
 * @version 1.0
 */
public class SimpleArrayTest {
    /**
     * Test for add and get methods.
     */
    @Test
    public void whenAddTwoElementsThenTheSameTwoElements() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(3);
        simpleArray.add(5);

        assertThat(simpleArray.get(0), is(3));
        assertThat(simpleArray.get(1), is(5));
    }

    /**
     * Test for set method.
     */
    @Test
    public void whenSetSecondElementThenNewSecondElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(3);
        simpleArray.add(5);
        simpleArray.set(1, 7);

        assertThat(simpleArray.get(1), is(7));
    }

    /**
     * Test for delete method.
     */
    @Test
    public void whenDeleteFirstElementThenSecondElementIsNowFirst() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("3");
        simpleArray.add("5");
        simpleArray.delete(0);

        assertThat(simpleArray.get(0), is("5"));
    }

    /**
     * Test with an incorrectly assigned index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void shoulThrowIndexOfBoundsException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("3");
        simpleArray.add("5");
        simpleArray.delete(2);
    }

    /**
     * Testing of automatic container increase.
     */
    @Test
    public void whenAddElementsMoreThanSizeOfContainerThanContainerIncreases() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("3");
        simpleArray.add("5");
        simpleArray.add("8");
        simpleArray.add("10");

        assertThat(simpleArray.get(3), is("10"));
    }

    /**
     * Iterator Testing.
     */
    @Test
    public void whenIteratorThanIteratorOfThisContainer() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("3");
        simpleArray.add("5");
        simpleArray.add("8");
        simpleArray.add("10");

        Iterator<String> iterator = simpleArray.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("5"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("8"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("10"));
        assertThat(iterator.hasNext(), is(false));
    }
}
