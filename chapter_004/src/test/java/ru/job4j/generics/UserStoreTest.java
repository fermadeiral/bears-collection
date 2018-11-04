package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class UserStoreTest | Task Solution: Implement Store<T extends Base> [#157]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.07.2018
 */
public class UserStoreTest {

    private UserStore us = new UserStore(3);

    @Test
    public void whenAddUserThenUserIsInStore() {
        User user = new User("001");
        us.add(user);
        assertThat(us.findById("001"), is(user));
    }

    @Test
    public void whenAddUserThenUserCanBeFindById() {
        User user = new User("001");
        us.add(user);
        assertThat(us.findById("001"), is(user));
    }

    @Test
    public void whenDeleteUserThenUserIsNotInStore() {
        us.add(new User("001"));
        us.delete("001");
        assertNull(us.findById("001"));
    }

    @Test
    public void whenReplaceUserInStoreThenOldItemIsDeleted() {
        us.add(new User("001"));
        User user = new User("002");
        us.replace("001", user);
        assertNull(us.findById("001"));
    }

    @Test
    public void whenReplaceUserInStoreThenOldElementIsReplacedByNew() {
        us.add(new User("001"));
        User user = new User("002");
        us.replace("001", user);
        assertThat(us.findById("002"), is(user));
    }
}