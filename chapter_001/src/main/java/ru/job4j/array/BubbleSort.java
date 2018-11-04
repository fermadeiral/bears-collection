package ru.job4j.array;

/**
 * Class BubbleSort 5.1. Создать программу для сортировки массива методом перестановки. [#195]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 30.10.2017
 */
public class BubbleSort {

    /**
     * Метод возвращает отсортированный массив.
     * @param array Массив для обработки.
     * @return Отсортированный массив.
     */
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
