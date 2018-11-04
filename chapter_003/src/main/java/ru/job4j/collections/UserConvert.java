package ru.job4j.collections;

import java.util.*;

/**
 * Class UserConvert Решение задачи: Написать программу преобразования List в Map. [#10093]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.02.2018
 */
public class UserConvert {

    /**
     * Метод конвертирует список с пользователями в Map с ключом Integer id.
     * @param list Список пользователей.
     * @return Map с пользователями по ключу Integer id.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap(list.size());
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}