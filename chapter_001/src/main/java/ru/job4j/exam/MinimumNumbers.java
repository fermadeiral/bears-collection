package ru.job4j.exam;

import java.util.Arrays;

/**
 * MinimumNumbers.
 * @author Ivan Belyaev
 * @since 26.08.2017
 * @version 1.0
 */
public class MinimumNumbers {
	/**
	 * The method searches the minimum of m numbers in the array and
	 * returns an array of m the minimum numbers.
	 * @param a - array of numbers.
	 * @param m - number of minimum numbers to be found.
	 * @return returns an array of m the minimum numbers.
	 */
    public int[] selectFirstMinimumNumbers(int[] a, int m) {
        sortMimimumNumbers(a, 0, a.length - 1, m);
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = a[i];
        }
        Arrays.sort(result);
        return result;
    }

	/**
	 * The method searches the minimum of m numbers in the array.
	 * @param a - array of numbers.
	 * @param p - the left border of the search.
	 * @param r - the right border of the search.
	 * @param m - number of minimum numbers to be found.
	 */
    private void sortMimimumNumbers(int[] a, int p, int r, int m) {
        if (p >= r) {
        	return;
        }

        int q = partition(a, p, r);

        if (q == m || (q + 1) == m) {
        	return;
        }

        if (q + 1 < m) {
            sortMimimumNumbers(a, q + 1, r, m);
        } else {
            sortMimimumNumbers(a, p, q - 1, m);
        }
    }

	/**
	 * The method divides a portion of the array into two parts.
	 * In the left part all the elements less than the right side.
	 * @param a - array of numbers.
	 * @param p - the left border of the search.
	 * @param r - the right border of the search.
	 * @return returns the border of division.
	 */
    private int partition(int[] a, int p, int r) {
        int q = p;
        for (int u = p; u < r; u++) {
            if (a[u] <= a[r]) {
                swap(a, q, u);
                q++;
            }
        }
        swap(a, q, r);
        return q;
    }

	/**
	 * The method swaps two cells in the array.
	 * @param a - array of numbers.
	 * @param index1 - the index of the first cell.
	 * @param index2 - the index of the second cell.
	 */
    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
