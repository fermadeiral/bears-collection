package ru.job4j.array;

/**
 * RotateArray.
 * @author Ivan Belyaev
 * @since 22.06.2017
 * @version 1.0
 */
public class RotateArray {
	/**
	 * the method rotates the array by 90 degrees.
	 * @param array - array of numbers.
	 * @return returns an array rotated 90 degrees clockwise.
	 */
	public int[][] rotate(int[][] array) {
		int n = array.length - 1; //last index
		for (int i = 0; i < array.length / 2; i++) {
			for (int j = 0; j < array.length - array.length / 2; j++) {
				int temp = array[i][j];
				array[i][j] = array[n - j][i];
				array[n - j][i] = array[n - i][n - j];
				array[n - i][n - j] = array[j][n - i];
				array[j][n - i] = temp;
			}
		}
		return array;
	}
}
