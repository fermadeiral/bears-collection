package ru.job4j.statistics;

import java.util.Objects;

/**
 * Class User | Task Solution: Collection statistics [#45889]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 08.10.2018
 */
public class User {
    private int id;
    private String name;

    /**
     * Getter.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter.
     */
    public String getName() {
        return name;
    }

    /**
     * Constructor.
     */
    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}