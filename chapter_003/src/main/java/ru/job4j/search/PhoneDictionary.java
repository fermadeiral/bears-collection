package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * PhoneDictionary.
 * @author Ivan Belyaev
 * @since 24.04.2018
 * @version 1.0
 */
public class PhoneDictionary {
    /** List of people. */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * The method adds a person to the phone dictionary.
     * @param person - the person you want to add.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * The method returns a list of all users that contain the key in any fields.
     * @param key - search key.
     * @return returns a list of all users that contain the key in any fields.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();

        for (Person person : persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key)
                    || person.getPhone().contains(key) || person.getAddress().contains(key)) {
                result.add(person);
            }
        }

        return result;
    }
}