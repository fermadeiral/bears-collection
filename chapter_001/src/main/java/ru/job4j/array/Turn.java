package ru.job4j.array;

/**
 * Class Turn 5.0 Перевернуть массив [#4441]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.10.2017
 */
public class Turn {

    /**
     * Метод возвращает перевернутый массив.
     * @param array Массив для обработки.
     * @return Перевернутый массив.
     */
    public static int[] back(int[] array) {
        /** Временное хранение очередного элемента */
        int temp;

        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
