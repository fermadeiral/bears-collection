package ru.job4j.array;

/**
 * Turn.
 * @author Ivan Belyaev
 * @since 21.06.2017
 * @version 1.0
 */
public class Turn {
	/**
	 * The method inverts an array of numbers.
	 * @param array - array of numbers.
	 * @return returns an inverted array.
	 */
	public int[] back(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;
	}
}
