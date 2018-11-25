package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TrackerTest.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class TrackerTest {
    /**
     * Test for the add method.
     */
    @Test
    public void whenAddOneToOneThenTwo() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("name2", "desc2", 1234L);
        tracker.add(item2);
        ArrayList<Item> methodReturns = tracker.findAll();

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the update method.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("name2", "desc2", 1234L);
        item2.setId(item1.getId());
        tracker.update(item2);
        String expected = "name2";
        assertThat(tracker.findById(item1.getId()).getName(), is(expected));
    }

    /**
     * Test for the delete method.
     */
    @Test
    public void whenDeleteOneFromTwoThenOne() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("name2", "desc2", 1234L);
        tracker.add(item2);
        tracker.delete(item1);
        ArrayList<Item> methodReturns = tracker.findAll();

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item2);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the findAll method.
     */
    @Test
    public void whenFindAllTwoFromTwoThenTwo() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("name1", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("name2", "desc2", 1234L);
        tracker.add(item2);
        ArrayList<Item> methodReturns = tracker.findAll();

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the findByName method.
     */
    @Test
    public void whenFindByNameAsTaskThenTwo() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("name", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("task", "desc4", 12345L);
        tracker.add(item3);
        ArrayList<Item> methodReturns = tracker.findByName("task");

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the findById method.
     */
    @Test
    public void whenFindByIdThenItemWithUniqueId() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task", "desc1", 123L);
        tracker.add(item1);
        Item item2 = new Item("name", "desc2", 1234L);
        tracker.add(item2);
        Item item3 = new Item("task", "desc4", 12345L);
        tracker.add(item3);
        Item methodReturns = tracker.findById(item2.getId());
        Item expected = item2;
        assertThat(methodReturns, is(expected));
    }
}