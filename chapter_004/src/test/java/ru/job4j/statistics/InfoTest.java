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
    public void whenAddElementThenOneAddedElement() {
        current.add(u4);
        assertThat(info.getAddedElements(previous, current), is(1));
    }

    @Test
    public void whenChangeElementThenOneChangedElement() {
        current.remove(u2);
        current.add(u3);
        assertThat(info.getChangedElements(previous, current), is(1));
    }

    @Test
    public void whenDeleteOneElementThenOneDeletedElement() {
        current.remove(u1);
        assertThat(info.getDeletedElements(previous, current), is(1));
    }
}