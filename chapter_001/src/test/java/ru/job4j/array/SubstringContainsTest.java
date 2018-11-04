package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 09.11.2017
 */
public class SubstringContainsTest {

    /**
     * Test contains.
     */
    @Test
    public void whenSubstringContainsInOriginStringThenContainsIsTrue() {
        String origin = "Test123tes";
        String sub = "est";
        boolean expected = true;
        boolean result = SubstringContains.contains(origin, sub);
        assertThat(result, is(expected));
    }

    /**
     * Test contains.
     */
    @Test
    public void whenSubstringIsNotContainsInOriginStringThenContainsIsFalse() {
        String origin = "Test123tes";
        String sub = "emt";
        boolean expected = false;
        boolean result = SubstringContains.contains(origin, sub);
        assertThat(result, is(expected));
    }

}
