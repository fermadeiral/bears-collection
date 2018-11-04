package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.02.2018
 */
public class ConvertListTest {

    /**
     * Test toList.
     */
    @Test
    public void whenSentArrayThenReturnListWithArrayElements() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        List<Integer> result = new ArrayList<>();
        result.addAll(ConvertList.toList(array));
        assertThat(result, is(expected));
    }

    /**
     * Test toArray.
     */
    @Test
    public void whenSentListThenReturnArrayWithListElements() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int[][] expected = {{1, 2, 3, 4}, {5, 6, 7, 0}};
        int[][] result = ConvertList.toArray(list, 2);
        assertThat(result, is(expected));
    }

    /**
     * Test convert.
     */
    @Test
    public void whenSentListWithArraysThenReturnListWithArraysElements() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        list.add(new int[]{6, 6, 12});
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(6);
        expected.add(6);
        expected.add(12);
        List<Integer> result = ConvertList.convert(list);
        assertThat(result, is(expected));
    }
}