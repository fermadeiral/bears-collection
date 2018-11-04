package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 31.10.2017
 */
public class RotateArrayTest {

    /**
     * Test rotate.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        int[][] array = new int[][] {{1, 2}, {3, 4}};
        int[][] result = RotateArray.rotate(array);
        int[][] expected = new int[][] {{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }

    /**
     * Test rotate.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        int[][] array = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = RotateArray.rotate(array);
        int[][] expected = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }
}