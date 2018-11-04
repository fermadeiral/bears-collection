package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class OwnQueueTest | Task Solution: Create Stack and Queue containers by using DynamicLinkedLlist container. [#160]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.08.2018
 */
public class OwnQueueTest {

    private OwnQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new OwnQueue<>();
        queue.push(1);
        queue.push(2);
    }

    @Test
    public void whenAddTwoElementsThenGetTwoElements() {
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
   }

    @Test
    public void whenPollAllElementsThenQueueIsEmpty() {
        queue.poll();
        queue.poll();
        assertNull(queue.poll());
    }
}