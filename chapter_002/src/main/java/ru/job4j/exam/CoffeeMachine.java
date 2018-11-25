package ru.job4j.exam;

import java.util.ArrayList;

/**
 * CoffeeMachine.
 * @author Ivan Belyaev
 * @since 04.12.2017
 * @version 1.0
 */
public class CoffeeMachine {
    /** Available coins. */
    private int[] coins = {10, 5, 2, 1};

    /**
     * Method give change from a vending machine.
     * @param value - the amount of money invested in the machine.
     * @param price - the price of the goods.
     * @throws NotEnoughMoneyException thrown when there is insufficient amount of funds.
     * @return returns an array of coins.
     */
    public int[] changes(int value, int price) throws NotEnoughMoneyException {
        ArrayList<Integer> list = new ArrayList<>();

        if (value - price < 0) {
            throw new NotEnoughMoneyException("Not enough money.");
        }

        int change = value - price;

        for (int i = 0; i < coins.length; i++) {
            while (change / coins[i] > 0) {
                list.add(coins[i]);
                change -= coins[i];
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
