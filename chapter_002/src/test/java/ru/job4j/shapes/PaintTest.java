package ru.job4j.shapes;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest.
 * @author Ivan Belyaev
 * @since 25.09.2017
 * @version 1.0
 */
public class PaintTest {
    /**
     * Test for trianle.
     */
    @Test
    public void whenPaintCallWithTriangleThenTrianleOnTheConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        Shape shape = new Triangle();
        paint.draw(shape);
        assertThat(
                out.toString(),
                is(
                        String.format("  *  %1$s *** %1$s*****%1$s", System.getProperty("line.separator"))
                )
        );
    }

    /**
     * Test for square.
     */
    @Test
    public void whenPaintCallWithSquareThenSquareOnTheConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        Shape shape = new Square();
        paint.draw(shape);
        assertThat(
                out.toString(),
                is(
                        String.format("****%1$s*  *%1$s*  *%1$s****%1$s", System.getProperty("line.separator"))
                )
        );
    }
}
