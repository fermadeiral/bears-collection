package ru.job4j.generics;

/**
 * @param <T> - the type of the elements of this container.
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {

    /**
     * The method adds an element to the container.
     * @param model - added item.
     */
    void add(T model);

    /**
     * The method replaces the item in the container.
     * @param id - id of the element being replaced.
     * @param model - new item.
     * @return returns true if the element has been replaced otherwise false.
     */
    boolean replace(String id, T model);

    /**
     * The method removes the item from the container.
     * @param id - id of the element being deleted.
     * @return returns true if the element has been deleted otherwise false.
     */
    boolean delete(String id);

    /**
     * The method returns an item from the container.
     * @param id - id of the desired element.
     * @return returns an item from the container.
     */
    T findById(String id);
}