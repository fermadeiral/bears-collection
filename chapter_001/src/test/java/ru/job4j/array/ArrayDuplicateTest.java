package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest.
 * @author Ivan Belyaev
 * @since 22.06.2017
 * @version 1.0
 */
public class ArrayDuplicateTest {
	/**
	 * Test for the remove method.
	 */
	@Test
	public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
		String[] methodReturns = arrayDuplicate.remove(
			new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"}
		);
		String[] expected = new String[] {"Привет", "Мир", "Супер"};
		assertThat(methodReturns, is(expected));
	}
}
