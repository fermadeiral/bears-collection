package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.10.2017
 */
public class PaintTest {
    /**
     * Test pyramid.
     */
    @Test
    public void whenPyramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.pyramid(2);
        String expected = String.format(" ^ %s^^^%s", System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }

    /**
     * Test pyramid.
     */
    @Test
    public void whenPyramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s",
                System.getProperty("line.separator"),
                System.getProperty("line.separator"),
                System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
}