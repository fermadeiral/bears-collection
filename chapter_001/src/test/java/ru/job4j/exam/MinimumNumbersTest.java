package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MinimumNumbersTest.
 * @author Ivan Belyaev
 * @since 26.08.2017
 * @version 1.0
 */
public class MinimumNumbersTest {
	/**
	 * Test for the selectFirstMinimumNumbers method.
	 * Find 5 minimal numbers from 17.
	 */
	@Test
	public void whenSelectFirstMinimumNumbersFiveFromSeventeenThenFiveMinimalNumbers() {
		MinimumNumbers minimumNumbers = new MinimumNumbers();
		int[] a = {17, 25, 13, 29, 0, 5, 7, 2, 15, 23, 44, 1, 6, 3, 9, 6, 4};
		int[] methodReturns = minimumNumbers.selectFirstMinimumNumbers(a, 5);
		int[] expected = {0, 1, 2, 3, 4};
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the selectFirstMinimumNumbers method.
	 * Find 7 minimal numbers from 17.
	 */
	@Test
	public void whenSelectFirstMinimumNumbersSevenFromSeventeenThenSevenMinimalNumbers() {
		MinimumNumbers minimumNumbers = new MinimumNumbers();
		int[] a = {17, 16, 10, 9, 15, 14, 8, 7, 13, 12, 6, 5, 11, 1, 2, 3, 4};
		int[] methodReturns = minimumNumbers.selectFirstMinimumNumbers(a, 7);
		int[] expected = {1, 2, 3, 4, 5, 6, 7};
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the selectFirstMinimumNumbers method.
	 * Find 8 minimal numbers from 17.
	 */
	@Test
	public void whenSelectFirstMinimumNumbersEightFromSeventeenThenEightMinimalNumbers() {
		MinimumNumbers minimumNumbers = new MinimumNumbers();
		int[] a = {5, 9, 4, 2, 3, 7, 6, 9, 1, 2, 17, 10, 8, 2, 11, 12, 21};
		int[] methodReturns = minimumNumbers.selectFirstMinimumNumbers(a, 8);
		int[] expected = {1, 2, 2, 2, 3, 4, 5, 6};
		assertThat(methodReturns, is(expected));
	}
}
