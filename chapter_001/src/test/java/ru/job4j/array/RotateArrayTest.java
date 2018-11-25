package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RotateArrayTest.
 * @author Ivan Belyaev
 * @since 22.06.2017
 * @version 1.0
 */
public class RotateArrayTest {
	/**
	 * Test for the rotate method, when an array of two by two.
	 */
	@Test
	public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] methodReturns = rotateArray.rotate(
			new int[][] {
				{1, 2},
				{3, 4}
			}
		);
		int[][] expected = new int[][] {
				{3, 1},
				{4, 2}
		};
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the rotate method, when an array of three by three.
	 */
	@Test
	public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
		RotateArray rotateArray = new RotateArray();
		int[][] methodReturns = rotateArray.rotate(
			new int[][] {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			}
		);
		int[][] expected = new int[][] {
				{7, 4, 1},
				{8, 5, 2},
				{9, 6, 3}
		};
		assertThat(methodReturns, is(expected));
	}
}
