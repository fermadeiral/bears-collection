package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 * @author Ivan Belyaev
 * @since 22.06.2017
 * @version 1.0
 */
public class ArrayDuplicate {
	/**
	 * The method removes duplicates in the array.
	 * @param array - array of strings.
	 * @return returns array without duplicates.
	 */
	public String[] remove(String[] array) {
		int n = array.length; //the number of different values
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (array[i].equals(array[j])) {
					String temp = array[j];
					array[j] = array[n - 1];
					array[n - 1] = temp;
					n--;
					i--;
					break;
				}
			}
		}
		return Arrays.copyOf(array, n);
	}
}

