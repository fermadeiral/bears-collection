package ru.job4j.shapes;

/**
 * Square.
 * The class implements the interface Shape.
 * @author Ivan Belyaev
 * @since 25.09.2017
 * @version 1.0
 */
public class Square implements Shape {
    /**
     * The method returns a square as a string.
     * @return returns a square as a string.
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("****");
        sb.append(System.getProperty("line.separator"));
        sb.append("*  *");
        sb.append(System.getProperty("line.separator"));
        sb.append("*  *");
        sb.append(System.getProperty("line.separator"));
        sb.append("****");
        return sb.toString();
    }
}
