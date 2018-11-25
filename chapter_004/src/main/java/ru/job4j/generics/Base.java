package ru.job4j.generics;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    /** Id. */
    private final String id;

    /**
     * The constructor creates the object Base.
     * @param id - id.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * The method returns an id of the object.
     * @return returns an id of the object.
     */
    public String getId() {
        return id;
    }
}