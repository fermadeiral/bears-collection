package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 30.01.2018
 */
public class CoffeeMachineTest {

    /**
     * Test changes.
     */
    @Test
    public void whenValueIs100andPriseIs22ThenResult() {
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 5, 2, 1};
        int[] result = CoffeeMachine.changes(100, 22);
        assertThat(expected, is(result));
    }
}
