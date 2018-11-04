package ru.job4j.list;

/**
 * Class OwnStack | Task Solution: Create Stack and Queue containers by using DynamicLinkedLlist container. [#160]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 05.08.2018
 */
public class OwnStack<E> {

    SimpleArrayList<E> list = new SimpleArrayList<>();

    /**
     * Add element to stack.
     * @param value element.
     */
    public void push(E value) {
        list.add(value);
    }

    /**
     * Poll first element from stack.
     * @return polled element.
     */
    public E poll() {
        return list.deleteLast();
    }
}