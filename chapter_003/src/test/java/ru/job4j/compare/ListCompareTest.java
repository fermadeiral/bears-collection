package ru.job4j.compare;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ListCompareTest.
 * @author Ivan Belyaev
 * @since 13.01.2018
 * @version 1.0
 */
public class ListCompareTest {
    /**
     * Test for compare method.
     * If the lists are equal.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(0));
    }

    /**
     * Test for compare method.
     * The elements of first list equal to the corresponding elements of the second,
     * but the second longer.
     */
    @Test
    public void whenLeftLessRightThenMunis() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(-1));
    }

    /**
     * Test for compare method.
     * Lists of the same length, but the elements of the first list more.
     */
    @Test
    public void whenLeftGreatRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2),
                Arrays.asList(1, 1)
        );
        assertThat(rst, is(1));
    }
}
