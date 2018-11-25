package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BubbleSortTest.
 * @author Ivan Belyaev
 * @since 22.06.2017
 * @version 1.0
 */
public class BubbleSortTest {
	/**
	 * Test for the sort method.
	 */
	@Test
	public void whenSortArrayThenSortedArray() {
		BubbleSort bubbleSort = new BubbleSort();
		int[] methodReturns = bubbleSort.sort(new int[] {5, 1, 2, 7, 3});
		int[] expected = new int[] {1, 2, 3, 5, 7};
		assertThat(methodReturns, is(expected));
	}
}
