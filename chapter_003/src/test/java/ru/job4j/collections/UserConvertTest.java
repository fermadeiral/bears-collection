package ru.job4j.collections;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.02.2018
 */
public class UserConvertTest {

    /**
     * Test process.
     */
    @Test
    public void whenSentListWithUsersThenGetHashMap() {
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(124, new User(124, "Egor", "Moscow"));
        List<User> list = new ArrayList<>();
        list.add(new User(124, "Egor", "Moscow"));
        HashMap<Integer, User> result = new UserConvert().process(list);
        assertThat(result, is(expected));
    }

    /**
     * Test process.
     */
    @Test
    public void whenSentEmptyListThenGetEmptyHashMap() {
        HashMap<Integer, User> expected = new HashMap<>();
        List<User> list = new ArrayList<>();
        HashMap<Integer, User> result = new UserConvert().process(list);
        assertThat(result, is(expected));
    }
}