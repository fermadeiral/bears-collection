package ru.job4j.map;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleHashMapTest.
 * @author Ivan Belyaev
 * @since 05.11.2018
 * @version 1.0
 */
public class SimpleHashMapTest {
    /**
     * First test for the insert method.
     */
    @Test
    public void whenInsertIntoMapOneElementThenMapHasOneElement() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("123", 1);

        assertThat(map.get("123"), is(1));
    }

    /**
     * Second test for the insert method.
     */
    @Test
    public void whenInsertIntoMapTwoElementsWithTheSameKeyThenMapHasLastElement() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("123", 1);
        map.insert("123", 2);

        assertThat(map.get("123"), is(2));
    }

    /**
     * Third test for the insert method.
     */
    @Test
    public void whenInsertIntoMapSomeElementsWithTheSameHashAndDoNotEqualsThenMapHasOnlyFirstElement() {
        /**
         * User.
         * The Class for the test.
         */
        class User {
            @Override
            public int hashCode() {
                return 1;
            }
        }

        SimpleHashMap<User, Integer> map = new SimpleHashMap<>();
        User user1 = new User();
        User user2 = new User();
        map.insert(user1, 1);
        map.insert(user2, 2);

        assertThat(map.get(user1), is(1));
        assertThat(map.getSize(), is(1));
    }

    /**
     * Test for the delete method.
     */
    @Test
    public void whenDeleteElementsThenMapDoesNotContainsTheir() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("123", 1);
        map.insert("321", 2);
        map.insert("456", 3);
        map.insert("789", 4);

        assertThat(map.getSize(), is(4));

        map.delete("123");
        map.delete("321");
        map.delete("789");

        assertThat(map.getSize(), is(1));
    }

    /**
     * Iterator Testing.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThanIteratorOfThisContainer() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("123", 1);
        map.insert("321", 2);
        map.insert("456", 3);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        Iterator<Integer> iterator = map.iterator();

        assertThat(iterator.hasNext(), Is.is(true));
        assertThat(iterator.hasNext(), Is.is(true));
        int curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(true));
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(true));
        curValue = iterator.next();
        assertThat(set.contains(curValue), Is.is(true));
        set.remove(curValue);
        assertThat(iterator.hasNext(), Is.is(false));
        iterator.next();
    }

    /**
     * Test behavior when the collection was modified during the action of the iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.insert("123", 1);
        Iterator<Integer> iterator = map.iterator();
        map.insert("456", 2);
        iterator.next();
    }

    /**
     * Test for the resize method.
     */
    @Test
    public void whenInsertIntoMapManyElementsThenMapResizes() {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        for (int i = 0; i < 32; i++) {
            map.insert(i + "", i);
        }

        assertThat(map.getSize(), is(32));
    }
}
