package ru.job4j.loop;

/**
 * Counter.
 * @author Ivan Belyaev
 * @since 19.06.2017
 * @version 1.0
 */
public class Counter {
	/**
	 * The method determines the amount of even numbers in the range.
	 * @param start - beginning of the range
	 * @param finish - end of the range
	 * @return returns the amount of even numbers in the range
	 */
	public int add(int start, int finish) {
		int sum = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
