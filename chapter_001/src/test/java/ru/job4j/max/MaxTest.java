package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class MaxTest {
	/**
	 * Test for the max method, when first is less than second.
	 */
	@Test
	public void whenMaxFiveCompareEightThenEight() {
		Max max = new Max();
		int methodReturns = max.max(5, 8);
		int expected = 8;
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the max method, when first is greater than second.
	 */
	@Test
	public void whenMaxSevenCompareThreeThenSeven() {
		Max max = new Max();
		int methodReturns = max.max(7, 3);
		int expected = 7;
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the max method with three parameters, when first is max.
	 */
	@Test
	public void whenMaxCompareSevenAndFourAndFiveThenSeven() {
		Max max = new Max();
		int methodReturns = max.max(7, 4, 5);
		int expected = 7;
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the max method with three parameters, when second is max.
	 */
	@Test
	public void whenMaxCompareSevenAndEightAndFiveThenEight() {
		Max max = new Max();
		int methodReturns = max.max(7, 8, 5);
		int expected = 8;
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the max method with three parameters, when third is max.
	 */
	@Test
	public void whenMaxCompareSevenAndEightAndNineThenNine() {
		Max max = new Max();
		int methodReturns = max.max(7, 8, 9);
		int expected = 9;
		assertThat(methodReturns, is(expected));
	}
}
