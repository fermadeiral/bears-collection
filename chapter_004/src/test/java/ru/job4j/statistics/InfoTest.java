package ru.job4j.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class InfoTest | Task Solution: Collection statistics [#45889]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 08.10.2018
 */
public class InfoTest {

    Info info = new Info();
    List<User> previous = new ArrayList<>();
    List<User> current = new ArrayList<>();
    User u1 = new User(1, "Ivan");
    User u2 = new User(3, "Oleg");
    User u3 = new User(3, "Oleg2");
    User u4 = new User(4, "Sergey");

    @Before
    public void init() {
        previous.add(u1);
        previous.add(u2);
        current.addAll(previous);
    }

    @Test
    public void whenListsAreEqualThenNoChanges() {
        info.compare(previous, current);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getDeleted(), is(0));
    }

    @Test
    public void whenAddElementThenOneAddedElement() {
        current.add(u4);
        info.compare(previous, current);
        assertThat(info.getAdded(), is(1));
    }

    @Test
    public void whenChangeElementThenOneChangedElement() {
        current.set(1, u3);
        info.compare(previous, current);
        assertThat(info.getChanged(), is(1));
    }

    @Test
    public void whenDeleteOneElementThenOneDeletedElement() {
        current.remove(u1);
        info.compare(previous, current);
        assertThat(info.getDeleted(), is(1));
    }
}