package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.12.2017
 */
public class SquareTest {
    /**
     * Test pic.
     */
    @Test
    public void whenDrawSquare() {
        Shape square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                                        .append("-------")
                                        .append(System.lineSeparator())
                                        .append("-------")
                                        .append(System.lineSeparator())
                                        .append("-------")
                                        .append(System.lineSeparator())
                                        .append("-------")
                                        .toString()
                )
        );
    }
}