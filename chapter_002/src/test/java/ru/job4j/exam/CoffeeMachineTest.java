package ru.job4j.exam;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CoffeeMachineTest.
 * @author Ivan Belyaev
 * @since 04.12.2017
 * @version 1.0
 */
public class CoffeeMachineTest {
    /**
     * The first test for the changes method.
     */
    @Test
    public void whenChangesFiftyAndThirtyFiveThenTwoCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] methodReturns = null;

        try {
            methodReturns = coffeeMachine.changes(50, 35);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        int[] expected = {10, 5};
        assertThat(methodReturns, is(expected));
    }

    /**
     * The second test for the changes method.
     */
    @Test
    public void whenChangesFiftyAndTwentyTwoThenFiveCoins() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] methodReturns = null;

        try {
            methodReturns = coffeeMachine.changes(50, 22);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }

        int[] expected = {10, 10, 5, 2, 1};
        assertThat(methodReturns, is(expected));
    }

    /**
     * The third test for the changes method.
     */
    @Test
    public void whenChangesThirtyAndSixtyThenNotEnoughMoneyException() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] methodReturns = null;

        try {
            methodReturns = coffeeMachine.changes(30, 60);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
        assertThat(
                out.toString().split(System.getProperty("line.separator"))[0],
                is("Not enough money.")
        );
    }
}
