package ru.job4j.array;

/**
 * BubbleSort.
 * @author Ivan Belyaev
 * @since 22.06.2017
 * @version 1.0
 */
public class BubbleSort {
	/**
	 * Method sorts an array with bubble sort.
	 * @param array - array of numbers.
	 * @return returns the sorted array.
	 */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean sorted = true;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }
        return array;
    }
}
