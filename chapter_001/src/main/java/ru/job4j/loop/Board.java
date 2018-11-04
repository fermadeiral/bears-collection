package ru.job4j.loop;

/**
 * Class Board 4.3. Построить шахматную доску в псевдографике. [#13559]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.10.2017
 */
public class Board {

    /**
     * Метод рисует шахматную доску.
     * @param width Ширина доски.
     * @param height Высота доски.
     * @return рисунок шахматной строки.
     */
    public String paint(int width, int height) {

        /** "Рисуем" доску с помощью класса StringBuilder */
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {

                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        builder.append(" ");
                    } else {
                        builder.append("x");
                    }
                } else {
                    if (j % 2 != 0) {
                        builder.append(" ");
                    } else {
                        builder.append("x");
                    }
                }

                if (j == width) {
                    builder.append(System.getProperty("line.separator"));
                }
            }
        }
        return builder.toString();
    }
}
