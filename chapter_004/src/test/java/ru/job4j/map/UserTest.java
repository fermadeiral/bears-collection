package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Class UserTest | Task Solution: equals() and hashCode() override [#1002]
 *  * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 *  * @since 02.09.2018
 *  */
public class UserTest {

    @Test
    public void userMapPrintResult() {
        User ivan = new User("Ivan", 1, 1985, 10, 11);
        User fedor = new User("Ivan", 1, 1985, 10, 11);

        Map map = new HashMap();
        map.put(ivan, "Ivan");
        map.put(fedor, "Ivan");
        System.out.println(map);
        System.out.println("Object equals - " + ivan.equals(fedor));
    }
}