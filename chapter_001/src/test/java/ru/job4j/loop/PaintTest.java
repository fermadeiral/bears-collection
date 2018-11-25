package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Paint.
 * @author Ivan Belyaev
 * @since 20.06.2017
 * @version 1.0
 */
public class PaintTest {
	/**
	 * Test for the piramid method, when height equals 2.
	 */
	@Test
	public void whenPiramidTwoThenPyramidOfHeightTwo() {
		Paint paint = new Paint();
		String methodReturns = paint.piramid(2);
		String expected = String.format(" ^ %s^^^",
			System.getProperty("line.separator")
		);
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the piramid method, when height equals 3.
	 */
	@Test
	public void whenPiramidThreeThenPyramidOfHeightThree() {
		Paint paint = new Paint();
		String methodReturns = paint.piramid(3);
		String expected = String.format("  ^  %s ^^^ %s^^^^^",
			System.getProperty("line.separator"),
			System.getProperty("line.separator")
		);
		assertThat(methodReturns, is(expected));
	}
}
