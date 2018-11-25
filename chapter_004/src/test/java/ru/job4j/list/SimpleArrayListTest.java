package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleArrayListTest.
 * @author Ivan Belyaev
 * @since 03.05.2018
 * @version 1.0
 */
public class SimpleArrayListTest {
    /** Container. */
    private SimpleArrayList<Integer> list;

    /**
     * Customize tests.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * Test for get method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * Test for getSize method.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    /**
     * Test for delete method.
     */
    @Test
    public void whenAddThreeElementsThenDeleteOneThenGetSizeResultTwoGetOneResultThree() {
        list.delete();

        assertThat(list.getSize(), is(2));
        assertThat(list.get(1), is(1));
    }
}
