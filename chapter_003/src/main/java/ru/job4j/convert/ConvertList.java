package ru.job4j.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertList.
 * @author Ivan Belyaev
 * @since 05.01.2018
 * @version 1.0
 */
public class ConvertList {
    /**
     * Method converts int[][] to List<Integer>.
     * @param array - array.
     * @return returns a List<Integer> containing all the elements of the input array.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] arr : array) {
            for (int elem : arr) {
                list.add(elem);
            }
        }

        return list;
    }

    /**
     * Method converts a List<Integer> to int[][].
     * The number of rows specified by the second parameter.
     * If the cardinality is not a multiple of the number of lines remaining values in the array to fill with zeros.
     * @param list - collection.
     * @param rows - the number of rows.
     * @return returns an int[][] filled with elements of the input collection.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][];

        int cols;
        if ((list.size() % rows) == 0) {
            cols = list.size() / rows;
        } else {
            cols = list.size() / rows + 1;
        }

        int rowsCounter = -1;
        int colsCounter = cols;
        for (int i : list) {
            if (colsCounter == cols) {
                colsCounter = 0;
                rowsCounter++;
                array[rowsCounter] = new int[cols];
            }

            array[rowsCounter][colsCounter++] = i;
        }

        return array;
    }

    /**
     * Method converts a List<int[]> to List<Integer>.
     * @param list - list<int[]>.
     * @return returns a List<Integer> containing all the integers of the input array.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();

        for (int[] array : list) {
            for (int elem : array) {
                result.add(elem);
            }
        }

        return result;
    }
}


