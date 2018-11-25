package ru.job4j.bank;

/**
 * Account.
 * @author Ivan Belyaev
 * @since 17.01.2018
 * @version 1.0
 */
public class Account {
    /** Account details. */
    private String requisites;
    /** The amount in the account. */
    private double value;

    /**
     * The constructor creates the object Account.
     * @param requisites - account details.
     * @param value - sum at account opening.
     */
    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    /**
     * The method provides details of the account.
     * @return returns details of the account.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * The method returns the amount in the account.
     * @return returns the amount in the account.
     */
    public double getValue() {
        return value;
    }

    /**
     * Method sets a new quantity of money in the account.
     * @param value - the new quantity of money in the account.
     */
    public void setValue(double value) {
        this.value = value;
    }
}
