package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * UserTest.
 * @author Ivan Belyaev
 * @since 13.10.2018
 * @version 1.0
 */
public class UserTest {
    /**
     * Test for User class.
     */
    @Test
    public void whenUserOverrideHachCodeAndEqualsThenHashMapHasSecondUser() {
        User firstUser = new User("Ivan", 3, new GregorianCalendar(2018, 10, 13));
        User secondUser = new User("Ivan", 3, new GregorianCalendar(2018, 10, 13));

        Map<User, Object> map = new HashMap<>();
        map.put(firstUser, 1);
        map.put(secondUser, 2);

        System.out.println(map);
    }
}
