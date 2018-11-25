package ru.job4j.condition;

/**
 * Point.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class Point {
	/** the field contains the x coordinate. */
	private int x;
	/** the field contains the y coordinate. */
	private int y;

	/**
	 * Constructs a point initialized coordinates.
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * The method returns the x coordinate.
	 * @return returns the x coordinate.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * The method returns the y coordinate.
	 * @return returns the y coordinate.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * The method checks is the point on the function y = a * x + b.
	 * @param a - parameter of function y = a * x + b
	 * @param b - parameter of function y = a * x + b
	 * @return returns true if the point is on function
	 */
	public boolean is(int a, int b) {
		return this.y == a * this.x + b;
	}
}
