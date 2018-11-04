package ru.job4j.array;

/**
 * Class ArraysMerge Слияние двух упорядоченных массивов одинакового размера.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.11.2017
 */
public class ArraysMerge {

    /**
     * Метод возвращает упорядоченный массив.
     * @param array1 Массив для слияния.
     * @param array2 Массив для слияния.
     * @return Упорядоченный массив, состоящий из элементов array1 и array2.
     */
    public static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length * 2];
        for (int i = 0, j = 0; i < array1.length; i++, j += 2) {
            if (array1[i] < array2[i]) {
                mergedArray[j] = array1[i];
                mergedArray[j + 1] = array2[i];
            } else {
                mergedArray[j] = array2[i];
                mergedArray[j + 1] = array1[i];
            }
        }
        return mergedArray;
    }
}