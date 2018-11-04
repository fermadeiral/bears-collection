package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.12.2017
 */
public class TriangleTest {
    /**
     * Test pic.
     */
    @Test
    public void whenDrawTriangle() {
        Shape triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                                          .append("   .   ")
                                          .append(System.lineSeparator())
                                          .append("   -   ")
                                          .append(System.lineSeparator())
                                          .append("  ---  ")
                                          .append(System.lineSeparator())
                                          .append(" ----- ")
                                          .append(System.lineSeparator())
                                          .append("-------")
                                          .toString()
                )
        );
    }
}
