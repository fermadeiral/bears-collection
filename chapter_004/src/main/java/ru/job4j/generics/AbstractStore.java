package ru.job4j.generics;

/**
 * Class AbstractStore | Task Solution: Implement Store<T extends Base> [#157]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.07.2018
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> store;

    /**
     * Constructor.
     */
    public AbstractStore(int size) {
        this.store = new SimpleArray<>(size);
    }

    /**
     * Add item to store.
     * @param model item.
     */
    @Override
    public void add(T model) {
        store.add(model);
    }

    /**
     * Find item by id in store.
     * @param id id.
     * @return item.
     */
    @Override
    public T findById(String id) {
        for (T item : store) {
            if ((item != null) && (item.getId().equals(id))) {
                return item;
            }
        }
        return null;
    }

    /**
     * Delete item by id in store.
     * @param id id.
     * @return true or false.
     */
    @Override
    public boolean delete(String id) {
        for (T item : store) {
            if ((item != null) && (item.getId().equals(id))) {
                store.delete(store.getElementIndex(item));
                return true;
            }
        }
        return false;
    }

    /**
     * Replace item in store.
     * @param id Replacing item id.
     * @param model New item.
     * @return true or false.
     */
    @Override
    public boolean replace(String id, T model) {
        for (T item : store) {
            if ((item != null) && (item.getId().equals(id))) {
                store.set(store.getElementIndex(item), model);
                return true;
            }
        }
        return false;
    }
}