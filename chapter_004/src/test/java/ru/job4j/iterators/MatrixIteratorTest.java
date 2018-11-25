package ru.job4j.iterators;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * MatrixIteratorTest.
 * Tests for the MatrixIterator class.
 * @author Ivan Belyaev
 * @since 26.04.2018
 * @version 1.0
 */
public class MatrixIteratorTest {
    /** Iterator. */
    private Iterator<Integer> it;

    /**
     * Customize tests.
     */
    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][] {{1, 2, 3}, {4, 5, 6}});
    }

    /**
     * The first test for the MatrixIterator class.
     * Rectangular matrix.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * The second test for the MatrixIterator class.
     * Rectangular matrix.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    /**
     * The third test for the MatrixIterator class.
     * Rectangular matrix.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    /**
     * The fourth test for the MatrixIterator class.
     * Rectangular matrix.
     */
    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        it = new MatrixIterator(new int[][]{});
        it.next();
    }
}