package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PriorityQueueTest.
 * @author Ivan Belyaev
 * @since 24.04.2018
 * @version 1.0
 */
public class PriorityQueueTest {
    /**
     * First test for put method.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * Second test for put method.
     */
    @Test
    public void whenPutTwoTasksWithHigherPriorityThenSecondTaskShouldBeLater() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent1", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent2", 1));

        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent1"));
        result = queue.take();
        assertThat(result.getDesc(), is("urgent2"));
    }
}