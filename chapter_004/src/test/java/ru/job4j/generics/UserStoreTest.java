package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * UserStoreTest.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public class UserStoreTest {
    /**
     * Test for add and findById methods.
     */
    @Test
    public void whenAddElementThenContainerHasTheSameElement() {
        Store<User> store = new UserStore(10);
        store.add(new User("Viktor", "7"));

        assertThat(store.findById("7").toString(), is("Viktor"));
    }

    /**
     * Test for replace method.
     */
    @Test
    public void whenReplaceElementThenContainerContainsNewElement() {
        Store<User> store = new UserStore(10);
        store.add(new User("Viktor", "7"));
        store.replace("7", new User("Roman", "3"));

        assertNull(store.findById("7"));
        assertThat(store.findById("3").toString(), is("Roman"));
    }

    /**
     * Test for delete method.
     */
    @Test
    public void whenDeleteElementThenContainerDoesNotContainTheElement() {
        Store<User> store = new UserStore(10);
        store.add(new User("Viktor", "7"));
        store.add(new User("Roman", "3"));
        store.delete("7");

        assertNull(store.findById("7"));
        assertThat(store.findById("3").toString(), is("Roman"));
    }
}
