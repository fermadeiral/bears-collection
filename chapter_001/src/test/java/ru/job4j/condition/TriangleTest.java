package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * TriangleTest.
 * @author Ivan Belyaev
 * @since 18.06.2017
 * @version 1.0
 */
public class TriangleTest {
	/**
	 * Test for the area method.
	 */
	@Test
	public void whenAreaThenSix() {
		Point a = new Point(2, 1);
		Point b = new Point(5, 1);
		Point c = new Point(5, 5);
		Triangle triangle = new Triangle(a, b, c);
		double methodReturns = triangle.area();
		double expected = 6d;
		assertThat(methodReturns, closeTo(expected, 0.01));
	}
}

