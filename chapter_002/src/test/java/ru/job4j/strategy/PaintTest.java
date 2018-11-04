package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.12.2017
 */
public class PaintTest {

    // Поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // Буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method");
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
        System.out.println("Execute after method");
    }

    /**
     * Test draw.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("-------")
                                .append(System.lineSeparator())
                                .append("-------")
                                .append(System.lineSeparator())
                                .append("-------")
                                .append(System.lineSeparator())
                                .append("-------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}