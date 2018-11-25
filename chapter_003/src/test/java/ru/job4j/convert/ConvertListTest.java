package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConvertListTest.
 * @author Ivan Belyaev
 * @since 05.01.2018
 * @version 1.0
 */
public class ConvertListTest {
    /**
     * Test for toList method.
     */
    @Test
    public void whenToListArrayThenList() {
        ConvertList convertList = new ConvertList();
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9, 10}
        };

        List<Integer> methodReturns = convertList.toList(array);
        List<Integer> expected = new ArrayList<>();
        Collections.addAll(expected, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for toArray method.
     */
    @Test
    public void whenToArrayListThenArrayWithRightAmountRows() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int[][] methodReturns = convertList.toArray(list, 4);
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 0}
        };

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for convert method.
     */
    @Test
    public void whenConverRecivesListOfArrayThenReturnsListOfInteger() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1, 2});
        list.add(new int[] {3, 4, 5});
        list.add(new int[] {6});
        list.add(new int[] {7, 8, 9, 10});

        List<Integer> methodReturns = convertList.convert(list);
        List<Integer> expected = new ArrayList<>();
        Collections.addAll(expected, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertThat(methodReturns, is(expected));
    }
}
