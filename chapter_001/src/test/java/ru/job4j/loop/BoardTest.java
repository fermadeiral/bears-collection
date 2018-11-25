package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BoardTest.
 * @author Ivan Belyaev
 * @since 19.06.2017
 * @version 1.0
 */
public class BoardTest {
	/**
	 * Test for the paint method, when 3x3.
	 */
	@Test
	public void whenPaintWidthThreeHeightThreeThenThreeOnThree() {
		Board board = new Board();
		String methodReturns = board.paint(3, 3);
		String expected = String.format("x x%s x %sx x%s",
			System.getProperty("line.separator"),
			System.getProperty("line.separator"),
			System.getProperty("line.separator")
		);
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the paint method, when 5x4.
	 */
	@Test
	public void whenPaintWidthFiveHeightFourThenFiveOnFour() {
		Board board = new Board();
		String methodReturns = board.paint(5, 4);
		String expected = String.format("x x x%s x x %sx x x%s x x %s",
			System.getProperty("line.separator"),
			System.getProperty("line.separator"),
			System.getProperty("line.separator"),
			System.getProperty("line.separator")
		);
		assertThat(methodReturns, is(expected));
	}
}
