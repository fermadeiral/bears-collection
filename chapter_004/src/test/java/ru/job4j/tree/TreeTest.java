package ru.job4j.tree;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    /**
     * First test for the findBy method.
     */
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Second test for the findBy method.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Test for the add method.
     */
    @Test
    public void whenAddIntoTreeElementWithNonExistentParentThenMethodReturnsFalse() {
        Tree<Integer> tree = new Tree<>(1);
        assertThat(
                tree.add(2, 3),
                is(false)
        );
    }

    /**
     * Iterator Testing.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThanIteratorOfThisContainer() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = tree.iterator();

        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.hasNext(), Is.is(true));
        int curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(true));
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(true));
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(true));
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(false));
        iterator.next();
    }

    /**
     * Test behavior when the collection was modified during the action of the iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        Iterator<Integer> iterator = tree.iterator();
        tree.add(2, 5);
        iterator.next();
    }

    /**
     * First test for the isBinary method.
     */
    @Test
    public void whenTreeIsBinaryThenIsBinaryReturnsTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }

    /**
     * Second test for the isBinary method.
     */
    @Test
    public void whenTreeIsNotBinaryThenIsBinaryReturnsFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }
}
