package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 18.10.2017
 */
public class PointTest {
    /**
     * Test is.
     */
    @Test
    public void whenPointOnLineThenTrue() {
        //create of new point.
        Point a = new Point(2, 8);
        // execute method - is and get result;
        boolean rsl = a.is(3, 2);
        // assert result by excepted value.
        assertThat(rsl, is(true));
    }
}
