package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PointTest.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class PointTest {
	/**
	 * Test for the is method.
	 */
	@Test
	public void whenIsATwoBFourPointXThreeYTenThenTrue() {
		Point point = new Point(3, 10);
		boolean methodReturns = point.is(2, 4);
		boolean expected = true;
		assertThat(methodReturns, is(expected));
	}
}
