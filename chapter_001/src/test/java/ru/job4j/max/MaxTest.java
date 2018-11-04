package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 18.10.2017
 */
public class MaxTest {

    /**
     * Test max with 2 arguments.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test max with three arguments.
     */
    @Test
    public void whenFirstAndSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 7, 9);
        assertThat(result, is(9));
    }
}
