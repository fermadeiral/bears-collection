package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleStackTest.
 * @author Ivan Belyaev
 * @since 11.05.2018
 * @version 1.0
 */
public class SimpleStackTest {
    /** Test for the stack. */
    @Test
    public void whenFirstInputThenLastOutput() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
