package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PhoneDictionaryTest.
 * @author Ivan Belyaev
 * @since 24.04.2018
 * @version 1.0
 */
public class PhoneDictionaryTest {
    /**
     * First test for find method.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("sen");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Second test for find method.
     */
    @Test
    public void whenFindThenListOfAllUsersContainingTheKey() {
        PhoneDictionary phones = new PhoneDictionary();

        Person oleg = new Person("Oleg", "Ivanov", "13545166", "Tomsk");
        Person katya = new Person("Katya", "Bukina", "15615610", "Ivanovo");
        Person denis = new Person("Denis", "Markov", "1351513", "Tver'");

        phones.add(oleg);
        phones.add(katya);
        phones.add(denis);

        List<Person> methodReturns = phones.find("va");

        List<Person> expected = new ArrayList<>();
        Collections.addAll(expected, oleg, katya);

        assertThat(methodReturns, is(expected));
    }
}