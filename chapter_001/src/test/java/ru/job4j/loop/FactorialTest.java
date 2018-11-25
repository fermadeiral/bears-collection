package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorialTest.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class FactorialTest {
	/**
	 * Test for the calc method, when the argument is zero.
	 */
	@Test
	public void whenCalcZeroThenOne() {
		Factorial factorial = new Factorial();
		int methodReturns = factorial.calc(0);
		int expected = 1;
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the calc method, when the argument is greater than one.
	 */
	@Test
	public void whenCalcFiveThenOneHundredTwenty() {
		Factorial factorial = new Factorial();
		int methodReturns = factorial.calc(5);
		int expected = 120;
		assertThat(methodReturns, is(expected));
	}
}
