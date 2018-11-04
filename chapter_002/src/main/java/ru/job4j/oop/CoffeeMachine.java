package ru.job4j.oop;

/**
 * Class CoffeeMachine Решение задачи Кофемашина. [#34741]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 30.01.2018
 */
public class CoffeeMachine {

    /**
     * Метод рассчитывает набор монет для сдачи.
     * @param value Номинал купюры.
     * @param price Цена кофе.
     * @return Возвращает набор монет.
     */
    public static int[] changes(int value, int price) {
        // 502 - максимально возможное количество монет в сдаче
        // при условии, что максимальный размер купюры - 5000 руб.,
        // а минимальная цена кофе - 1 руб.
        final int MAX_SIZE = 502;
        int[] change = new int[MAX_SIZE];
        final int[] coins = {10, 5, 2, 1};
        int[] result;
        int index = 0;
        int rest = value - price;
        for (int coin : coins) {
            while (rest >= coin) {
                rest -= coin;
                change[index] = coin;
                index++;
            }
        }
        result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = change[i];
        }
        return result;
    }
}