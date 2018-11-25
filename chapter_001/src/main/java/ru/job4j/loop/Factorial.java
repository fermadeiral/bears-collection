package ru.job4j.loop;

/**
 * Factorial.
 * @author Ivan Belyaev
 * @since 19.06.2017
 * @version 1.0
 */
public class Factorial {
	/**
	 * The method determines the factorial.
	 * @param n - the number for which factorial is defined by
	 * @return returns the factorial of a number
	 */
	public int calc(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}
