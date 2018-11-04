package ru.job4j.collections.comparable;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.02.2018
 */
public class SortUserTest {

    /**
     * Test sort.
     */
    @Test
    public void whenNoOrderedUserListThenGetSetOrderedByAge() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 32));
        users.add(new User("Fedor", 28));
        Set<User> result = new SortUser().sort(users);
        Set<User> expected = new TreeSet<>();
        expected.add(new User("Ivan", 32));
        expected.add(new User("Fedor", 28));
        assertThat(result, is(expected));
    }

    /**
     * Test sortByNameLenght.
     */
    @Test
    public void whenNoOrderedUserListThenGetListOrderedByNameLenght() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 32));
        users.add(new User("Max", 21));
        List<User> result = new SortUser().sortByNameLength(users);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Max", 21));
        expected.add(new User("Ivan", 32));
        assertThat(result, is(expected));
    }

    /**
     * Test sortByAllFields.
     */
    @Test
    public void whenNoOrderedUserListThenGetListOrderedByAllFields() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 13));
        users.add(new User("Fedor", 28));
        users.add(new User("Ivan", 24));
        List<User> result = new SortUser().sortByAllFields(users);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Fedor", 28));
        expected.add(new User("Ivan", 13));
        expected.add(new User("Ivan", 24));
        assertThat(result, is(expected));
    }
}