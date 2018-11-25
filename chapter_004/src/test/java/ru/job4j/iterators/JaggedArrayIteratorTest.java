package ru.job4j.iterators;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * JaggedArrayIteratorTest.
 * Tests for the MatrixIterator class.
 * @author Ivan Belyaev
 * @since 26.04.2018
 * @version 1.0
 */
public class JaggedArrayIteratorTest {
    /** Iterator. */
    private Iterator<Integer> it;

    /**
     * Customize tests.
     */
    @Before
    public void setUp() {
        it = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    /**
     * The first test for the MatrixIterator class.
     * JaggedArray.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    /**
     * The second test for the MatrixIterator class.
     * JaggedArray.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(7));
    }

    /**
     * The third test for the MatrixIterator class.
     * JaggedArray.
     */
    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }
}