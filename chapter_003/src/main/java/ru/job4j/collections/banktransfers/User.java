package ru.job4j.collections.banktransfers;

import java.util.Objects;

/**
 * Class Bank Task Solution: Bank transfers [#10038]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 24.04.2018
 */
class User implements Comparable {
    private final String name;
    private final String passport;

    /**
     * Constructor.
     */
    User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Getter.
     */
    String getName() {
        return this.name;
    }

    /**
     * Getter.
     */
    String getPassport() {
        return this.passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return this.name.compareTo(user.name);
    }
}