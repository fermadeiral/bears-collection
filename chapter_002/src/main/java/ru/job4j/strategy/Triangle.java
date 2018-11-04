package ru.job4j.strategy;

/**
 * Class Triangle Реализация фигуры "треугольник".
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.12.2017
 */
public class Triangle implements Shape {

    /**
     * Метод рисует фигуру в формат String.
     * @return Фигура.
     */
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("   .   ");
        picture.append(System.lineSeparator());
        picture.append("   -   ");
        picture.append(System.lineSeparator());
        picture.append("  ---  ");
        picture.append(System.lineSeparator());
        picture.append(" ----- ");
        picture.append(System.lineSeparator());
        picture.append("-------");
        return picture.toString();
    }
}
