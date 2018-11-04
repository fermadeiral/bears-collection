package ru.job4j.array;

/**
 * Class SubstringContains 7. Проверка, что одно слово находится в другом слове [#228]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 02.09.2017
 */
public class SubstringContains {

    /**
     * Метод проверяет, что слово String находится в другом слове String.
     * @param origin Строка, которая будет проверяться на нахождение в ней другой строки.
     * @param sub Строка, которую мы ищем в строке origin.
     * @return Результат проверки.
     */
    static boolean contains(String origin, String sub) {
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        boolean result = false;
        int match = 0;

        for (int i = 0; i < originArray.length; i++) {
            if (match == subArray.length) {
                break;
            }
            if (originArray[i] == subArray[0]) {
                int index = i;

                for (int j = 0; j < subArray.length; j++) {
                    if ((originArray[index] == subArray[j]) & (index < originArray.length)) {
                        result = true;
                        index++;
                        match++;
                    } else {
                        result = false;
                        match = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
