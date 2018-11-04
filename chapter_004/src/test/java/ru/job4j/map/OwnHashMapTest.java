package ru.job4j.map;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Class ownHashMapTest | Task Solution: Make own HashMap implementation [#1008]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.09.2018
 */
public class OwnHashMapTest {
    private OwnHashMap<User, String> map = new OwnHashMap<>();

    @Test
    public void whenInsertPairThenGetPairValue() {
        User ivan = new User("Ivan", 1, 1985, 10, 11);
        map.insert(ivan, "Ivan");
        assertThat(map.get(ivan), is("Ivan"));
    }

    @Test
    public void whenInsertTwoPairsWithSameKeysThenGetFalseForSecondPairt() {
        User ivan = new User("Ivan", 1, 1985, 10, 11);
        map.insert(ivan, "Ivan");
        assertThat(map.insert(ivan, "Ivan v2"), is(false));
    }

    @Test
    public void whenInsertPairWithNullKeyThenGetPairValue() {
        map.insert(null, "Ivan");
        assertThat(map.get(null), is("Ivan"));
    }

    @Test
    public void whenDeletePairThenThereIsNoElementInStorage() {
        User ivan = new User("Ivan", 1, 1985, 10, 11);
        map.insert(ivan, "Ivan");
        map.delete(ivan);
        assertThat(map.get(ivan), is(nullValue()));
    }
}