package ru.job4j.statistics;

import java.util.List;

/**
 * Class Store | Task Solution: Collection statistics [#45889]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 08.10.2018
 */
public class Store {

    /**
     * Get compare information.
     * @param previous List of elements.
     * @param current  Possibly modified list of elements.
     * @return Info Compare information.
     */
    Info diff(List<User> previous, List<User> current) {
        return new Info().compare(previous, current);
    }
}