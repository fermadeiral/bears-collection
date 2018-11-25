package ru.job4j.compare;

import java.util.Comparator;

/**
 * StringCompare.
 * @author Ivan Belyaev
 * @since 25.04.2018
 * @version 1.0
 */
public class StringCompare implements Comparator<String> {
    /**
     * The method compares two lines. Comparison in lexicographical order.
     * @param left - first string.
     * @param right - second string.
     * @return returns zero if the strings are equal.
     * A number greater than zero if the first string is greater than second string.
     * The number is less than zero if the first string is smaller than second string.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;

        int minLength = Math.min(left.length(), right.length());

        int i = 0;
        for (; i < minLength; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }

        if (i < left.length() && result == 0) {
            result = 1;
        }

        if (i < right.length() && result == 0) {
            result = -1;
        }

        return result;
    }
}