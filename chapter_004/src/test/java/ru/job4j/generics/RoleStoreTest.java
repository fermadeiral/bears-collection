package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

/**
 * Class RoleStoreTest | Task Solution: Implement Store<T extends Base> [#157]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.07.2018
 */
public class RoleStoreTest {

    private RoleStore rs = new RoleStore(3);

    @Test
    public void whenAddRoleThenRoleIsInStore() {
        Role role = new Role("001");
        rs.add(role);
        assertThat(rs.findById("001"), is(role));
    }

    @Test
    public void whenAddRoleThenRoleCanBeFindById() {
        Role role = new Role("001");
        rs.add(role);
        assertThat(rs.findById("001"), is(role));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNotInStore() {
        rs.add(new Role("001"));
        rs.delete("001");
        assertNull(rs.findById("001"));
    }

    @Test
    public void whenReplaceRoleInStoreThenOldItemIsDeleted() {
        rs.add(new Role("001"));
        Role role = new Role("002");
        rs.replace("001", role);
        assertNull(rs.findById("001"));
    }

    @Test
    public void whenReplaceRoleInStoreThenOldElementIsReplacedByNew() {
        rs.add(new Role("001"));
        Role role = new Role("002");
        rs.replace("001", role);
        assertThat(rs.findById("002"), is(role));
    }
}