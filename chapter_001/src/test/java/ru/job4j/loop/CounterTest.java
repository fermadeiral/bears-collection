package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 * @author Ivan Belyaev
 * @since 19.06.2017
 * @version 1.0
 */
public class CounterTest {
	/**
	 * Test for the add method.
	 */
	@Test
	public void whenAddFromOneToTenThenThirty() {
		Counter counter = new Counter();
		int methodReturns = counter.add(1, 10);
		int expected = 30;
		assertThat(methodReturns, is(expected));
	}
}
