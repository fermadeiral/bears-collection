package ru.job4j.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class PerformedTest Решение задачи Тестирование производительности коллекций.[#39757]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 02.02.2018
 */
public class PerformanceTest {

    private Collection<String> collection;

    /**
     * Метод вычисляет время добавления элементов в коллекцию.
     * @param collection Collection.
     * @param amount Количество элементов.
     * @return Время добавления элементов в коллекцию.
     */
    public long add(Collection<String> collection, int amount) {
        this.collection = collection;
        long before = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            Double doub = (Math.random() * 25487512);
            String temp = doub.toString();
            collection.add(temp);
        }
        return System.currentTimeMillis() - before;
    }

    /**
     * Метод вычисляет время удаления элементов из начала коллекции.
     * @param collection Collection.
     * @param amount Количество удаляемых элементов.
     * @return Время удаления элементов из начала коллекции.
     */
    public long delete(Collection<String> collection, int amount) {
        this.collection = collection;
        if (collection.isEmpty()) {
            add(this.collection, 200000);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            if (collection instanceof TreeSet) {
                ((TreeSet) collection).pollFirst();
            } else if (collection instanceof ArrayList) {
                ((ArrayList) collection).remove(0);
            } else if (collection instanceof LinkedList) {
                ((LinkedList) collection).remove(0);
            }
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Main.
     * @param args Args.
     */
    public static void main(String[] args) {
        PerformanceTest pt = new PerformanceTest();

        ArrayList<String> al = new ArrayList<>();
        System.out.println(String.format("ArrayList adding: %s", pt.add(al, 200000)));
        System.out.println(String.format("ArrayList deleting: %s", pt.delete(al, 15000)));

        LinkedList<String> ll = new LinkedList<>();
        System.out.println(String.format("LinkedList adding: %s", pt.add(ll, 200000)));
        System.out.println(String.format("LinkedList deleting: %s", pt.delete(ll, 15000)));

        TreeSet<String> ts = new TreeSet<>();
        System.out.println(String.format("TreeSet adding: %s", pt.add(ts, 200000)));
        System.out.println(String.format("TreeSet deleting: %s", pt.delete(ts, 15000)));
    }
}