package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class SimpleArray Task Solution: Implement SimpleArray<T> [#156]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.05.2018
 */
public class SimpleArrayTest {


    @Test
    public void whenAddIntegerValueThenGetValue() {
        SimpleArray array = new SimpleArray<Integer>(1);
        Integer element = 15;
        array.add(element);
        assertThat(array.get(0), is(element));
    }

    @Test
    public void whenAddStringValueThenGetValue() {
        SimpleArray array = new SimpleArray<String>(1);
        String element = "String";
        array.add(element);
        assertThat(array.get(0), is(element));
    }

    @Test
    public void whenSetValueInPositionThenGetValue() {
        SimpleArray array = new SimpleArray<Integer>(5);
        Integer element = 15;
        array.set(3, element);
        assertThat(array.get(3), is(element));
    }

    @Test
    public void whenDeleteValueThenThereIsNoValue() {
        SimpleArray array = new SimpleArray<Integer>(5);
        Integer element = 15;
        array.set(3, element);
        array.delete(3);
        assertNull(array.get(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        SimpleArray array = new SimpleArray<Integer>(1);
        Iterator<Integer> iterator = array.iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        SimpleArray<Integer> array = new SimpleArray<>(3);
        Iterator<Integer> iterator = array.iterator();
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }
}