package ru.job4j.generics;

/**
 * Class Base | Task Solution: Implement Store<T extends Base> [#157]
 * @author Petr Arsentev (mailto:parsentev@yandex.ru)
 * @since 14.12.2017
 */
abstract class Base {

    private final String id;

    /**
     * Constructor.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Getter
     */
    public String getId() {
        return id;
    }
}
