package ru.job4j.speedtest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

/**
 * TestCollections.
 * @author Ivan Belyaev
 * @since 05.01.2018
 * @version 1.0
 */
public class TestCollections {
    /** The array for getting random string. */
    private char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    /** To produce a random index in the array of characters. */
    private Random random = new Random();

    /**
     * The method adds random strings to the collection.
     * @param collection - collection.
     * @param amount - the number of strings to add.
     * @return returns the time spent on adding in milliseconds.
     */
    public long add(Collection<String> collection, int amount) {
        Date start = new Date();

        for (int i = 0; i < amount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(chars[random.nextInt(26)]);
            }
            collection.add(sb.toString());
        }

        Date finish = new Date();

        return finish.getTime() - start.getTime();
    }

    /**
     * The method removes the first elements from the collection.
     * @param collection - collection.
     * @param amount - the number of elements to delete.
     * @return returns the time taken to delete in milliseconds.
     */
    public long delete(Collection<String> collection, int amount) {
        Date start = new Date();

        Iterator<String> iterator = collection.iterator();
        for (int i = 0; i < amount; i++) {
            iterator.next();
            iterator.remove();
        }

        Date finish = new Date();

        return finish.getTime() - start.getTime();
    }

    /**
     * Method for testing collections.
     * @param args - command-line arguments.
     */
    public static void main(String[] args) {
        TestCollections testCollections = new TestCollections();

        Collection<String> linkedList = new LinkedList<>();
        Collection<String> arrayList = new ArrayList<>();
        Collection<String> treeSet = new TreeSet<>();

        int n = 1000000;
        System.out.println("Add " + n + " elements in collection.");
        System.out.println("LinkedList: " + testCollections.add(linkedList, n));
        System.out.println("ArrayList: " + testCollections.add(arrayList, n));
        System.out.println("TreeSet: " + testCollections.add(treeSet, n));

        int m = 1000000;
        System.out.println("Delete " + m + " elements from collection.");
        System.out.println("LinkedList: " + testCollections.delete(linkedList, m));
        System.out.println("ArrayList: " + testCollections.delete(arrayList, m));
        System.out.println("TreeSet: " + testCollections.delete(treeSet, m));
    }
}
