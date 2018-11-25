package ru.job4j.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleHashSetTest.
 * @author Ivan Belyaev
 * @since 31.05.2018
 * @version 1.0
 */
public class SimpleHashSetTest {
    /**
     * Test for add and contains methods.
     * First test.
     */
    @Test
    public void whenAddThreeDifferentElementsThenSetHasThreeTheSameElements() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.contains(1), is(true));
        assertThat(set.contains(2), is(true));
        assertThat(set.contains(3), is(true));
        assertThat(set.size(), is(3));
    }

    /**
     * Test for add and contains methods.
     * Second test.
     */
    @Test
    public void whenAddSeveralIdenticalElementsThenSetHasOnlyOneSuchElement() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(2);
        set.add(1);

        assertThat(set.contains(1), is(true));
        assertThat(set.contains(2), is(true));
        assertThat(set.contains(3), is(true));
        assertThat(set.size(), is(3));
    }

    /**
     * Test for remove method.
     */
    @Test
    public void whenAddThreeDifferentElementsThenRemoveOneElementSetHasTwoElements() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.remove(2);

        assertThat(set.contains(1), is(true));
        assertThat(set.contains(2), is(false));
        assertThat(set.contains(3), is(true));
        assertThat(set.size(), is(2));
    }

    /**
     * Iterator testing.
     */
    @Test
    public void whenIteratorThanIteratorOfThisContainer() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();

        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test behavior when the collection was modified during the action of the iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();
        set.add(5);

        iterator.next();
    }

    /**
     * The test of the fact that the container is growing.
     */
    @Test
    public void whenTheNumberOfElementsIncreasesThenTheContainerAlsoIncreases() {
        SimpleHashSet<Integer> set = new SimpleHashSet<>();

        for (int i = 0; i < 17; i++) {
            set.add(i);
        }

        assertThat(set.size(), is(17));
    }
}
