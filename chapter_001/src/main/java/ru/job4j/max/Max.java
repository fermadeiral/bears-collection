package ru.job4j.max;

/**
 * Max.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class Max {
	/**
	 * The method determines the maximum of two numbers.
	 * @param first - first number
	 * @param second - second number
	 * @return returns the maximum of two numbers
	 */
	public int max(int first, int second) {
		return first > second ? first : second;
	}

	/**
	 * The method determines the maximum of three numbers.
	 * @param first - first number
	 * @param second - second number
	 * @param third - third number
	 * @return returns the maximum of three numbers
	 */
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}
