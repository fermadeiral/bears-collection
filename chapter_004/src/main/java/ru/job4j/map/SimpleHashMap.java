package ru.job4j.map;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * SimpleHashMap.
 * @param <K> - key.
 * @param <V> - value.
 * @author Ivan Belyaev
 * @since 05.11.2018
 * @version 1.0
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    /**
     * Node.
     * Entry for storing key-value pairs.
     * @param <K> - key.
     * @param <V> - value.
     */
    private static class Node<K, V> {
        /** Key. */
        private K key;
        /** Value. */
        private V value;
        /** HashCode. */
        private int hash;
        /** Next node. */
        private Node<K, V> next;

        /**
         * The constructor creates the object Node.
         * @param key - key.
         * @param value - value.
         * @param next - next node.
         */
        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = key.hashCode();
        }
    }

    /** Maximum capacity. */
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    /** Maximum fill rate. */
    private final double loadFactor = 0.75;
    /** Item storage. */
    private Node<K, V>[] table;
    /** Capacity. */
    private int capacity = 16;
    /** Fill threshold. */
    private int threshold  = (int) (capacity * loadFactor);
    /** Size. */
    private int size = 0;
    /** The number of times this HashMap has been structurally modified. */
    private int modCount = 0;

    /**
     * The constructor creates the object SimpleHashMap.
     */
    public SimpleHashMap() {
        table = (Node<K, V>[]) new Node[capacity];
    }

    /**
     * The method adds a pair to the map.
     * Does not add elements at collisions.
     * @param key - key.
     * @param value - value.
     * @return true if the item is added false if not.
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        boolean isFound = false;
        int keyHash = key.hashCode();
        int index = keyHash & (capacity - 1);

        for (Node<K, V> curNode = table[index]; curNode != null; curNode = curNode.next) {
            if (keyHash == curNode.hash) {
                if (key == curNode.key || (key != null && key.equals(curNode.key))) {
                    curNode.value = value;
                } else {
                    result = false;
                }
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            table[index] = new Node<>(key, value, table[index]);
            size++;
            modCount++;
            if (size > threshold) {
                resize();
            }
        }
        return result;
    }

    /**
     * The method returns the value of the specified key.
     * @param key - key.
     * @return the value of the specified key or null if the item is not found.
     */
    public V get(K key) {
        V result = null;
        int keyHash = key.hashCode();
        int index = keyHash & (capacity - 1);

        for (Node<K, V> curNode = table[index]; curNode != null; curNode = curNode.next) {
            if (keyHash == curNode.hash && (key == curNode.key || (key != null && key.equals(curNode.key)))) {
                    result = curNode.value;
                    break;
                }
        }

        return result;
    }

    /**
     * The method deletes a pair by the specified key.
     * @param key - key.
     * @return true if the pair is removed false if not.
     */
    public boolean delete(K key) {
        boolean result = false;
        int keyHash = key.hashCode();
        int index = keyHash & (capacity - 1);

        Node<K, V> prevNode = null;
        for (Node<K, V> curNode = table[index]; curNode != null; prevNode = curNode, curNode = curNode.next) {
            if (keyHash == curNode.hash && (key == curNode.key || (key != null && key.equals(curNode.key)))) {
                if (prevNode == null) {
                    table[index] = curNode.next;
                } else {
                    prevNode.next = curNode.next;
                }
                size--;
                modCount++;
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * The method returns the number of items in the collection.
     * @return the number of items in the collection.
     */
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int counter = 0;
            private int index = 0;
            private int expectedModCount = modCount;
            private Node<K, V> node;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public V next() {
                V result;
                if (counter < size) {
                    if (node == null) {
                        for (; index < table.length; index++) {
                            if (table[index] != null) {
                                node = table[index++];
                                break;
                            }
                        }
                    }
                } else {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                result = node.value;
                node = node.next;
                counter++;
                return result;
            }
        };
    }

    /**
     * Method doubles table size.
     */
    private void resize() {
        if (capacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
        } else {
            capacity = capacity * 2;
            threshold = threshold * 2;
            Node<K, V>[] newTable = (Node<K, V>[]) new Node[capacity];
            for (int index = 0; index < table.length; index++) {
                for (Node<K, V> node = table[index]; node != null;) {
                    Node<K, V> temp = node.next;
                    int newIndex = node.hash & (capacity - 1);
                    node.next = newTable[newIndex];
                    newTable[newIndex] = node;
                    node = temp;
                }
            }
            table = newTable;
        }
    }
}
