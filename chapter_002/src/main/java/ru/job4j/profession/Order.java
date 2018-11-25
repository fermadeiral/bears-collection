package ru.job4j.profession;

/**
 * Order.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class Order {
    /** The field contains the name of the detail. */
    private String detailName;

    /**
     * The constructor creates the object Order.
     * @param detailName - the name of the detail.
     */
    public Order(String detailName) {
        this.detailName = detailName;
    }

    /**
     * The method returns the name of the detail.
     * @return returns the name of the detail.
     */
    public String getDetailName() {
        return this.detailName;
    }
}
