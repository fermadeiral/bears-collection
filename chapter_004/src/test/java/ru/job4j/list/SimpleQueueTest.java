package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleQueueTest.
 * @author Ivan Belyaev
 * @since 11.05.2018
 * @version 1.0
 */
public class SimpleQueueTest {
    /** Test for the queue. */
    @Test
    public void whenFirstInputThenFirstOutput() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}
