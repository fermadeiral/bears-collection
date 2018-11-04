package ru.job4j.loop;

/**
 * Class Paint 4.4. Построить пирамиду в псевдографике. [#4412]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.10.2017
 */
public class Paint {

    /**
     * Метод рисует пирамиду.
     * @param h Высота пирамиды.
     * @return рисунок шахматной строки.
     */
    public String pyramid(int h) {

        /** "Рисуем" пирамиду с помощью класса StringBuilder. */
        StringBuilder builder = new StringBuilder();

        /** Ширина пирамиды. */
        int width = h * 2 - 1;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= width; j++) {
                if ((j > (h - i)) && (j < h + i)) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }

                if (j == width) {
                    builder.append(System.getProperty("line.separator"));
                }
            }
        }
        return builder.toString();
    }
}
