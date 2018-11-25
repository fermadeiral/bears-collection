package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * RoleStoreTest.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public class RoleStoreTest {
    /**
     * Test for add and findById methods.
     */
    @Test
    public void whenAddElementThenContainerHasTheSameElement() {
        Store<Role> store = new RoleStore(10);
        store.add(new Role("Admin", "7"));

        assertThat(store.findById("7").toString(), is("Admin"));
    }

    /**
     * Test for replace method.
     */
    @Test
    public void whenReplaceElementThenContainerContainsNewElement() {
        Store<Role> store = new RoleStore(10);
        store.add(new Role("Admin", "7"));
        store.replace("7", new Role("User", "3"));

        assertNull(store.findById("7"));
        assertThat(store.findById("3").toString(), is("User"));
    }

    /**
     * Test for delete method.
     */
    @Test
    public void whenDeleteElementThenContainerDoesNotContainTheElement() {
        Store<Role> store = new RoleStore(10);
        store.add(new Role("Admin", "7"));
        store.add(new Role("User", "3"));
        store.delete("7");

        assertNull(store.findById("7"));
        assertThat(store.findById("3").toString(), is("User"));
    }
}
