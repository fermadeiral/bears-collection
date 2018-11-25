package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleSetTest.
 * @author Ivan Belyaev
 * @since 13.05.2018
 * @version 1.0
 */
public class SimpleSetTest {
    /**
     * Test for add method.
     * First test.
     */
    @Test
    public void whenAddThreeDifferentElementsThenSetHasThreeTheSameElements() {
        SimpleSet<Integer> set = new SimpleSet<>();
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
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(2);
        set.add(1);

        Iterator<Integer> iterator = set.iterator();

        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }
}
