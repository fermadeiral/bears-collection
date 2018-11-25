package ru.job4j.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SortUserTest.
 * @author Ivan Belyaev
 * @since 11.01.2018
 * @version 1.0
 */
public class SortUserTest {
    /**
     * Test for sort method.
     */
    @Test
    public void whenSortListOfUsersThenSortedSet() {
        SortUser sortUser = new SortUser();

        User anna = new User("Anna", 23);
        User denis = new User("Denis", 21);
        User sergey = new User("Sergey", 25);

        List<User> list = new ArrayList<>();
        list.add(anna);
        list.add(denis);
        list.add(sergey);

        Set<User> methodReturns = sortUser.sort(list);

        Set<User> expected = new LinkedHashSet<>();
        expected.add(denis);
        expected.add(anna);
        expected.add(sergey);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for sortNameLength method.
     */
    @Test
    public void whenSortNameLengthListOfUsersThenListSortedByNameLength() {
        SortUser sortUser = new SortUser();

        User sergey = new User("Sergey", 25);
        User anna = new User("Anna", 23);
        User denis = new User("Denis", 21);

        List<User> list = new ArrayList<>();
        list.add(sergey);
        list.add(anna);
        list.add(denis);

        List<User> methodReturns = sortUser.sortNameLength(list);

        List<User> expected = new ArrayList<>();
        expected.add(anna);
        expected.add(denis);
        expected.add(sergey);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for sortByAllFields method.
     */
    @Test
    public void whensortByAllFieldsListOfUsersThenListSortedByAllFields() {
        SortUser sortUser = new SortUser();

        User sergey = new User("Sergey", 25);
        User sergey2 = new User("Sergey", 30);
        User anna = new User("Anna", 23);
        User denis = new User("Denis", 21);
        User anna2 = new User("Anna", 20);

        List<User> list = new ArrayList<>();
        list.add(sergey);
        list.add(sergey2);
        list.add(anna);
        list.add(denis);
        list.add(anna2);

        List<User> methodReturns = sortUser.sortByAllFields(list);

        List<User> expected = new ArrayList<>();
        expected.add(anna2);
        expected.add(anna);
        expected.add(denis);
        expected.add(sergey);
        expected.add(sergey2);

        assertThat(methodReturns, is(expected));
    }
}
