package ru.job4j.generics;

/**
 * Interface Store | Task Solution: Implement Store<T extends Base> [#157]
 * @author Petr Arsentev (mailto:parsentev@yandex.ru)
 * @since 14.12.2017
 */
public interface Store<T extends Base> {

    /**
     * Add item to store.
     * @param model item.
     */
    void add(T model);
    /**
     * Replace item in store.
     * @param id Replacing item id.
     * @param model New item.
     * @return true or false.
     */
    boolean replace(String id, T model);
    /**
     * Delete item by id in store.
     * @param id id.
     * @return true or false.
     */
    boolean delete(String id);
    /**
     * Find item by id in store.
     * @param id id.
     * @return item.
     */
    T findById(String id);
}