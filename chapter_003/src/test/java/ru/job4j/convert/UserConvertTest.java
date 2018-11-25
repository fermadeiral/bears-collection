package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserConvertTest.
 * @author Ivan Belyaev
 * @since 10.01.2018
 * @version 1.0
 */
public class UserConvertTest {
    /**
     * Test for process method.
     */
    @Test
    public void whenProcessListThenMapWithTheSameUsers() {
        UserConvert userConvert = new UserConvert();

        User andrey = new User(11, "Andrey", "Moscow");
        User ira = new User(22, "Ira", "Saint Petersburg");
        User alex = new User(33, "Alexander", "Vladivostok");

        List<User> list = new ArrayList<>();
        list.add(andrey);
        list.add(ira);
        list.add(alex);

        HashMap<Integer, User> methodReturns = userConvert.process(list);

        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(andrey.getId(), andrey);
        expected.put(ira.getId(), ira);
        expected.put(alex.getId(), alex);

        assertThat(methodReturns, is(expected));
    }
}
