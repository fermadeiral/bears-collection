package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Class User | Task Solution: equals() and hashCode() override [#1002]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 02.09.2018
 */
public class User {

    private final String name;
    private int children;
    private final Calendar birthday;

    public User(String name, int children, int year, int month, int day) {
        this.name = name;
        this.children = children;
        this.birthday = new GregorianCalendar(year, month, day);
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
        return children == user.children && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children);
    }
}