package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TurnTest.
 * @author Ivan Belyaev
 * @since 19.06.2017
 * @version 1.0
 */
public class TurnTest {
	/**
	 * Test for the back method, when the array is an even number of elements.
	 */
	@Test
	public void whenBackEvenNumberOfElemenstThenInvertedArray() {
		Turn turn = new Turn();
		int[] methodReturns = turn.back(new int[] {4, 1, 6, 2});
		int[] expected = new int[] {2, 6, 1, 4};
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the back method, when the array is an odd number of elements.
	 */
	@Test
	public void whenBackOddNumberOfElemenstThenInvertedArray() {
		Turn turn = new Turn();
		int[] methodReturns = turn.back(new int[] {1, 2, 3, 4, 5});
		int[] expected = new int[] {5, 4, 3, 2, 1};
		assertThat(methodReturns, is(expected));
	}
}
