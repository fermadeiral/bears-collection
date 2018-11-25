package ru.job4j.shapes;

/**
 * Paint.
 * @author Ivan Belyaev
 * @since 25.09.2017
 * @version 1.0
 */
public class Paint {
    /**
     * The method renders the shape on the console.
     * @param shape - figure you want to withdraw.
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}
