package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.11.2017
 */
public class ArraysMergeTest {

    /**
     * Test merge.
     */
    @Test
    public void whenMergeTwoOrderedArraysThenOrderedArray() {
        int[] array1 = {1, 4, 6, 7, 10};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] result = ArraysMerge.merge(array1, array2);
        int[] expected = {1, 1, 2, 4, 3, 6, 4, 7, 5, 10};
        assertThat(result, is(expected));
    }
}