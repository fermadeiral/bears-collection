package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculatorTest.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class CalculatorTest {
	/**
	 * Test for the add method.
	 */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

	/**
	 * Test for the substruct method.
	 */
    @Test
    public void whenSubstructThreeMinusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.substruct(3D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

	/**
	 * Test for the div method.
	 */
    @Test
    public void whenDivSixDividedTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

	/**
	 * Test for the multiple method.
	 */
    @Test
    public void whenMultipleFiveMultipliedTwoThenTen() {
        Calculator calc = new Calculator();
        calc.multiple(5D, 2D);
        double result = calc.getResult();
        double expected = 10D;
        assertThat(result, is(expected));
    }
}
