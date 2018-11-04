package ru.job4j.collections.banktransfers;

/**
 * Class Bank Task Solution: Bank transfers [#10038]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 24.04.2018
 */
class Account {
    private double value;
    private final String requisites;

    /**
     * Constructor.
     */
    Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Getter.
     */
    double getValue() {
        return this.value;
    }

    /**
     * Getter.
     */
    String getRequisites() {
        return this.requisites;
    }

    /**
     * Setter.
     */
    void setValue(double value) {
        this.value = value;
    }
}