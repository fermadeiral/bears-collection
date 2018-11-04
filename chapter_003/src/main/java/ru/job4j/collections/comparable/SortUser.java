package ru.job4j.collections.comparable;

import java.util.*;

/**
 * Class SortUser Решение задачи: Организовать сортировку User [#10034]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 13.02.2018
 */
public class SortUser {

    /**
     * Метод возвращает TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * @param list List.
     * @return TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

    /**
     * Метод возвращает ArrayList пользователей, отсортированных по длине имени.
     * @param list List.
     * @return ArrayList пользователей, отсортированных по длине имени.
     */
    public List<User> sortByNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User left, User right) {
                return Integer.compare(left.name.length(), right.name.length());
            }
        });
        return list;
    }

    /**
     * Метод возвращает ArrayList пользователей, отсортированных по всем полям в порядке возрастания.
     * @param list List.
     * @return ArrayList пользователей, отсортированных по всем полям в порядке возрастания.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User left, User right) {
                int nameCompare = left.name.compareTo(right.name);
                return nameCompare != 0 ? nameCompare : Integer.compare(left.age, right.age);
            }
        });
        return list;
    }
}