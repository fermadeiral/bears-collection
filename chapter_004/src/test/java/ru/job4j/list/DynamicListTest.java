package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class DynamicListTest | Task Solution: Create dynamic list based on array [#158]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 03.08.2018
 */
public class DynamicListTest {

    @Test
    public void whenAddIntegerValueThenGetValue() {
        DynamicList<Integer> array = new DynamicList();
        array.add(15);
        assertThat(array.get(0), is(15));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        DynamicList array = new DynamicList<Integer>(1);
        Iterator<Integer> iterator = array.iterator();
        iterator.next();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldThrowConcurrentModificationException() {
        DynamicList array = new DynamicList<Integer>(1);
        Iterator<Integer> iterator = array.iterator();
        array.add(1);
        array.add(2);
        iterator.next();
    }

    @Test
    public void whenAddElementToFullContainerThenContainerIsGrow() {
        DynamicList<Integer> array = new DynamicList<>(1);
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(array.getSize(), is(4));
    }
}