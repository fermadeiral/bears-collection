package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate 5.3. Удаление дубликатов в массиве. [#225]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 02.11.2017
 */
public class ArrayDuplicate {

    /**
     * Метод возвращает обрезанный массив без дубликатов.
     * @param array Массив для обработки.
     * @return Обработанный массив.
     */
    public static String[] remove(String[] array) {
        int unique = array.length;
        for (int i = 0; i < unique; i++) {
            for (int j = i + 1; j < unique; j++) {
                if (array[j].equals(array[i])) {
                    array[j] = array[unique - 1];
                    unique--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
