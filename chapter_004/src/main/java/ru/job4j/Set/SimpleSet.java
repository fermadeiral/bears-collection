package ru.job4j.set;

import ru.job4j.list.DynamicList;
import java.util.Iterator;

/**
 * Class SimpleSet | Task Solution: Implement Set based on array [#996]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 11.08.2018
 */
public class SimpleSet<E> implements Iterable<E> {

    private DynamicList<E> list = new DynamicList<>();

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }

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
}