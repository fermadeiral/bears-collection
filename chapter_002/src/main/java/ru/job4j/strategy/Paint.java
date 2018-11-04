package ru.job4j.strategy;

/**
 * Class Paint 4. Используя шаблон проектирования - стратегию [#786]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.12.2017
 */
public class Paint {

    /**
     * Метод рисует заданную фигуру.
     * @param shape фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Метод main.
     * @param args args.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        System.out.println("");
        paint.draw(new Triangle());
    }

}
