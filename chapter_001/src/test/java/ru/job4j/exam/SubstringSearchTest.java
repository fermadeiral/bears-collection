package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SubstringSearchTest.
 * @author Ivan Belyaev
 * @since 03.07.2017
 * @version 1.0
 */
public class SubstringSearchTest {
	/**
	 * Test for the contains method, when the substring is contained in string.
	 */
	@Test
	public void whenContainsTheStringHasThisSubstringThenTrue() {
		SubstringSearch substringSearch = new SubstringSearch();
		boolean methodReturns = substringSearch.contains("Привет", "иве");
		boolean expected = true;
		assertThat(methodReturns, is(expected));
	}

	/**
	 * Test for the contains method, when the substring is not contained in the string.
	 */
	@Test
	public void whenContainsTheStringDoesNotHaveThisSubstringThenFalse() {
		SubstringSearch substringSearch = new SubstringSearch();
		boolean methodReturns = substringSearch.contains("Привет", "игла");
		boolean expected = false;
		assertThat(methodReturns, is(expected));
	}
}
