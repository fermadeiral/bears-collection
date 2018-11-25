package ru.job4j.compare;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * ListCompare.
 * @author Ivan Belyaev
 * @since 13.01.2018
 * @version 1.0
 */
public class ListCompare implements Comparator<List<Integer>> {
    /**
     * Method compares two lists of integers.
     * Lists are compared element by element from left to right.
     * If the elements are not equal, it returns the result of their comparison.
     * If any of the lists ends, the large is the one in which were the elements.
     * With equal length and equal elements of a list are equal.
     * @param left - first list.
     * @param right - second list.
     * @return returns -1 if the first list is greater, 1 if the second is greater, 0 if lists are equal.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        Iterator<Integer> leftIterator = left.iterator();
        Iterator<Integer> rightIterator = right.iterator();

        int result = 0;
        while (leftIterator.hasNext() && rightIterator.hasNext()) {
            result = Integer.compare(leftIterator.next(), rightIterator.next());
            if (result != 0) {
                break;
            }
        }

        if (result == 0) {
            if (leftIterator.hasNext()) {
                result = 1;
            }

            if (rightIterator.hasNext()) {
                result = -1;
            }
        }

        return result;
    }
}
