package ru.job4j.compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SortUser.
 * @author Ivan Belyaev
 * @since 11.01.2018
 * @version 1.0
 */
public class SortUser {
    /**
     * The method returns sorted Set<User>.
     * @param list - the list of users.
     * @return returns sorted Set<User>.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * The method sorts the list of users by user name length.
     * @param users - list of users.
     * @return returns a list sorted by the length of the user name.
     */
    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        return users;
    }

    /**
     * The method sorts the list of users on both fields.
     * First sort by name in lexicographical order, then by age.
     * @param users - list of users.
     * @return returns a list of users sorted by both fields.
     */
    public List<User> sortByAllFields(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
           @Override
           public int compare(User o1, User o2) {
               int result = o1.getName().compareTo(o2.getName());

               if (result == 0) {
                   result = o1.getAge() - o2.getAge();
               }

               return result;
           }
        });

        return users;
    }
}
