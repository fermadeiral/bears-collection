package ru.job4j.convert;

import java.util.HashMap;
import java.util.List;

/**
 * UserConvert.
 * @author Ivan Belyaev
 * @since 10.01.2018
 * @version 1.0
 */
public class UserConvert {
    /**
     * The method converts a List<User> into a Map with a key of an Integer id and its corresponding User.
     * @param list - the list of users.
     * @return - returns a Map with key User.id and the value of the User.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();

        for (User user : list) {
            result.put(user.getId(), user);
        }

        return result;
    }
}
