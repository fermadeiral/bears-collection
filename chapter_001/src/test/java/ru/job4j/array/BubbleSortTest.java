package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 30.10.2017
 */
public class BubbleSortTest {
    /**
     * Test sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] array = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = BubbleSort.sort(array);
        int[] expected = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8 };
        assertThat(result, is(expected));
    }
}