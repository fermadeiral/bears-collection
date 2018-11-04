package ru.job4j.set;

import ru.job4j.list.DynamicLinkedList;
import java.util.Iterator;

/**
 * Class SimpleLinkedListSet | Task Solution: Implement Set based on LinkedList [#997]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 11.08.2018
 */
public class SimpleLinkedListSet<E> implements Iterable<E> {

    private DynamicLinkedList<E> list = new DynamicLinkedList<>();

    /**
     * Add element to set.
     * @param value element.
     */
    public void add(E value) {
        boolean isPresent = false;
        for (E element : list) {
            if (element.equals(value)) {
                isPresent = true;
                break;
            }
        }
        if (!isPresent) {
            list.add(value);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}