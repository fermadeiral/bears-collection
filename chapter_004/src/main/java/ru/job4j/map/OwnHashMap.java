package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class OwnHashMap | Task Solution: Make own HashMap implementation [#1008]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 23.09.2018
 */
public class OwnHashMap<K, V> implements Iterable<OwnHashMap.Entry<K, V>> {

    private static final int DEFAULT_INITIAL_CAPACITY = 2;
    private Object[] table;
    private int size;
    private int modCount;

    /**
     * Generate entry hash code.
     * @param key entry key.
     * @return hash code.
     */
    private static int hash(Object key) {
        int h;
        int result;
        if (key == null) {
            result = 0;
        } else {
            h = key.hashCode();
            result = h ^ (h >>> 16);
        }
        return result;
    }

    /**
     * Constructor.
     */
    public OwnHashMap() {
        this.table = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * Add entry to storage.
     * @param key   entry key.
     * @param value entry value.
     * @return true if entry added to storage.
     * @return false if other entry with same key presented in storage.
     */
    public boolean insert(K key, V value) {
        if (table.length - 1 == size) {
            resize();
        }
        if (key == null) {
            insertForNullKey(value);
            return true;
        }

        int index = hash(key) & (table.length - 1);
        Entry<K, V> e = (Entry<K, V>) table[index];
        if (e == null) {
            addEntry(hash(key), key, value, index);
        } else {
            if (e.getKey().equals(key)) {
                return false;
            }
            e.next = new Entry<>(hash(key), key, value);
        }
        size++;
        modCount++;
        return true;
    }

    /**
     * Add entry without key to storage.
     * @param value entry value.
     * @return true if entry added to storage.
     * @return false if other entry without key presented in storage.
     */
    private boolean insertForNullKey(V value) {
        if (table[0] != null) {
            return false;
        }
        table[0] = new Entry(0, null, value);
        size++;
        modCount++;
        return true;
    }

    /**
     * Add entry to index position in table.
     * @param hash  entry hash.
     * @param key   entry key.
     * @param value entry value.
     * @param index position in table for adding entry.
     */
    private void addEntry(int hash, K key, V value, int index) {
        table[index] = new Entry<>(hash, key, value);
    }

    /**
     * Get entry value from storage.
     * @param key entry key.
     * @return true if entry presented in storage.
     */
    public V get(K key) {
        Entry<K, V> e = getEntry(hash(key), key);
        return e == null ? null : e.value;
    }

    /**
     * Get entry from storage.
     * @param hash entry hash code.
     * @param key  entry key.
     * @return true if entry presented in storage.
     */
    private Entry<K, V> getEntry(int hash, Object key) {
        Entry<K, V> first = (Entry<K, V>) table[(table.length - 1) & hash];
        Entry<K, V> e;
        if (first != null) {
            if (first.hash == hash && first.key == key || (key != null && key.equals(first.key))) {
                return first;
            }
            e = first.next;
            if (e != null) {
                while (e != null) {
                    if (e.hash == hash && key == e.key || (key != null && key.equals(first.key))) {
                        return e;
                    }
                    e = e.next;
                }
            }
        }
        return null;
    }

    /**
     * Delete entry from storage.
     * @param key entry key.
     * @return true if deleted.
     */
    public boolean delete(K key) {
        int index = hash(key) & (table.length - 1);
        Entry<K, V> e = getEntry(hash(key), key);
        Entry<K, V> temp = (Entry<K, V>) table[index];
        if (e == null) {
            return false;
        }
        if (e.next == null && e.equals(table[index])) {
            table[index] = null;
        } else {
            while (!temp.next.equals(e)) {
                temp = temp.next;
            }
            temp.next = e.next;
        }
        size--;
        modCount++;
        return true;
    }

    /**
     * Double table[] length.
     */
    private void resize() {
        if (table.length < (1 << 30)) {
            Object[] oldTable = table;
            table = new Object[oldTable.length * 2];
            for (Object element : oldTable) {
                Entry<K, V> e = (Entry<K, V>) element;
                if (e != null) {
                    this.insert(e.getKey(), e.getValue());
                    while (e.next != null) {
                        this.insert(e.next.getKey(), e.next.getValue());
                        e = e.next;
                    }
                }
            }
        }
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            Entry<K, V> next;
            Entry<K, V> current;
            int expectedModCount = modCount;
            int index = 0;

            public final boolean hasNext() {
                return next != null;
            }

            public final Entry<K, V> next() {
                if (table != null && size > 0) {
                    while (index < table.length && next == null) {
                        next = (Entry<K, V>) table[index++];
                    }
                }
                Entry<K, V> e = next;
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (e == null) {
                    throw new NoSuchElementException();
                }
                current = e;
                next = current.next;
                if (next == null && (table != null)) {
                    do {
                        next = (Entry<K, V>) table[index++];
                    } while (index < table.length && next == null);
                }
                return e;
            }
        };
    }

    /**
     * Class Entry | Task Solution: Make own HashMap implementation [#1008]
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 23.09.2018
     */
    static class Entry<K, V> {
        final int hash;
        final private K key;
        final private V value;
        Entry<K, V> next;

        /**
         * Constructor.
         */
        Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        /**
         * Getter.
         */
        K getKey() {
            return key;
        }

        /**
         * Getter.
         */
        V getValue() {
            return value;
        }
    }
}