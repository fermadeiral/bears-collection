package ru.job4j.collections.comparable;

import java.util.Comparator;

/**
 * Class ListCompare Решение задачи: Компаратор для строк. [#35008]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 19.03.2018
 */
public class ListCompare implements Comparator<String> {

    /**
     * Метод сравнивает две строки в лексикографическом порядке.
     * @param left Строка.
     * @param right Строка.
     * @return значение compareTo для двух строк.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;

        for (int i = 0; (i < left.length()) && (i < right.length()); i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
            if (left.charAt(i) != right.charAt(i)) {
                break;
            }
        }
        if ((result == 0) && (left.length() != right.length())) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}