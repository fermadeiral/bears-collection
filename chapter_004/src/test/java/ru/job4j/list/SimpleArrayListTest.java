package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayListTest Task Solution: Create method delete for simply-connected list [#51424]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 03.08.2018
 */
public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteElementThenGetDeletedElement() {
        assertThat(list.deleteLast(), is(3));
    }

    @Test
    public void whenDeleteAllElementsInListThenListIsEmpty() {
        assertThat(list.deleteLast(), is(3));
        assertThat(list.deleteLast(), is(2));
        assertThat(list.deleteLast(), is(1));
        assertNull(list.deleteLast());
    }
}