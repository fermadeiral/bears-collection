package ru.job4j.condition;

/**
 * Triangle.
 * @author Ivan Belyaev
 * @since 18.06.2017
 * @version 1.0
 */
public class Triangle {
	/** The field contains a vertex A of the triangle. */
	private Point a;
	/** The field contains a vertex B of the triangle. */
	private Point b;
	/** The field contains a vertex C of the triangle. */
	private Point c;

	/**
	 * Constructs a triangle initialized coordinates.
	 * @param a - vertex A of the triangle.
	 * @param b - vertex B of the triangle.
	 * @param c - vertex C of the triangle.
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * The method returns the area of a triangle.
	 * @return returns the area of a triangle.
	 */
	public double area() {
		double lengthOfSideAB = Math.sqrt(
			Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2)
		);
		double lengthOfSideAC = Math.sqrt(
			Math.pow((a.getX() - c.getX()), 2) + Math.pow((a.getY() - c.getY()), 2)
		);
		double lengthOfSideBC = Math.sqrt(
			Math.pow((b.getX() - c.getX()), 2) + Math.pow((b.getY() - c.getY()), 2)
		);
		double properiter = (lengthOfSideAB + lengthOfSideAC + lengthOfSideBC) / 2;

		if (lengthOfSideAB + lengthOfSideAC <= lengthOfSideBC) {
			return 0d;
		} else if (lengthOfSideAB + lengthOfSideBC <= lengthOfSideAC) {
			return 0d;
		} else if (lengthOfSideBC + lengthOfSideAC <= lengthOfSideAB) {
			return 0d;
		} else {
			return Math.sqrt(
				properiter
					* (properiter - lengthOfSideAB)
						 * (properiter - lengthOfSideAC)
						 	 * (properiter - lengthOfSideBC)
			);
		}
	}
}
