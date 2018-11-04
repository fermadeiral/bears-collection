package ru.job4j.array;

/**
 * Class RotateArray 5.2. Создание программы поворота квадратного массива. [#223]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 31.10.2017
 */
public class RotateArray {

    /**
     * Метод возвращает перевернутый квадратный массив.
     * @param array Массив для обработки.
     * @return Перевернутый массив.
     */
    public static int[][] rotate(int[][] array) {
        for (int i = 0; i < array.length / 2; i++) {
            for (int j = i; j < array.length - 1 - i; j++) {
                int temp;
                temp = array[i][j];
                array[i][j] = array[array.length - 1 - j][i];
                array[array.length - 1 - j][i] = array[array.length - 1 - i][array.length - 1 - j];
                array[array.length - 1 - i][array.length - 1 - j] = array[j][array.length - 1 - i];
                array[j][array.length - 1 - i] = temp;
            }
        }
        return array;
    }
}
