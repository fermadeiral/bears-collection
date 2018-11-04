package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.10.2017
 */
public class TurnTest {
    /**
     * Test back.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        int[] array = new int[] {2, 6, 1, 4};
        int[] result = Turn.back(array);
        int[] expected = new int[] {4, 1, 6, 2};
        assertThat(result, is(expected));
    }

    /**
     * Test back.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[] result = Turn.back(array);
        int[] expected = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
