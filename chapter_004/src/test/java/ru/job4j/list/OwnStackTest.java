package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class OwnStackTest | Task Solution: Create Stack and Queue containers by using DynamicLinkedLlist container. [#160]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.08.2018
 */
public class OwnStackTest {

    private OwnStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new OwnStack<>();
        stack.push(1);
        stack.push(2);
    }

    @Test
    public void whenAddTwoElementsThenGetTwoElements() {
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

    @Test
    public void whenPollAllElementsThenQueueIsEmpty() {
        stack.poll();
        stack.poll();
        assertNull(stack.poll());
    }
}