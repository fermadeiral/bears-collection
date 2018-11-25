package ru.job4j.calculator;

/**
 * Calculator.
 * @author Ivan Belyaev
 * @since 17.06.2017
 * @version 1.0
 */
public class Calculator {
	/** Field stores the result of the calculation. */
	private double result;

	/**
	 * The method adds two numbers.
	 * @param first - first summand
	 * @param second - second summand
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * The method calculates the difference between two numbers.
	 * @param minuend - minuend
	 * @param subtrahend - subtrahend
	 */
	public void substruct(double minuend, double subtrahend) {
		this.result = minuend - subtrahend;
	}

	/**
	 * The method calculates division of two numbers.
	 * @param dividend - dividend
	 * @param divisor - divisor
	 */
	public void div(double dividend, double divisor) {
		this.result = dividend / divisor;
	}

	/**
	 * The method multiplies two numbers.
	 * @param first - first multiplicand
	 * @param second - second multiplicand
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 * The method returns the result.
	 * @return returns the result of the calculation
	 */
	public double getResult() {
		return this.result;
	}
}
