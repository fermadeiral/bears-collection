package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleSetOnLinkedListTest.
 * @author Ivan Belyaev
 * @since 14.05.2018
 * @version 1.0
 */
public class SimpleSetOnLinkedListTest {
    /** Set. */
    private SimpleSetOnLinkedList<Integer> set = new SimpleSetOnLinkedList<>();

    /**
     * Test for add method.
     * First test.
     */
    @Test
    public void whenAddThreeDifferentElementsThenSetHasThreeTheSameElements() {
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();

        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test for add method.
     * Second test.
     */
    @Test
    public void whenAddSeveralIdenticalElementsThenSetHasOnlyOneSuchElement() {
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(6);
        set.add(5);
        set.add(4);

        Iterator<Integer> iterator = set.iterator();

        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(false));
    }
}
