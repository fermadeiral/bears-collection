package ru.job4j.generics;

/**
 * AbstractStore.
 * @param <T> - the type of the elements of this container.
 * @author Ivan Belyaev
 * @since 02.05.2018
 * @version 1.0
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /** Storage. */
    private SimpleArray<T> storage;

    /**
     * The constructor to initialize the repository.
     * @param size - original size.
     */
    public AbstractStore(int size) {
        storage = new SimpleArray<>(size);
    }

    /**
     * The method adds an element to the container.
     * @param model - added item.
     */
    @Override
    public void add(T model) {
        storage.add(model);
    }

    /**
     * The method replaces the item in the container.
     * @param id - id of the element being replaced.
     * @param model - new item.
     * @return returns true if the element has been replaced otherwise false.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;

        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId().equals(id)) {
                storage.set(i, model);
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * The method removes the item from the container.
     * @param id - id of the element being deleted.
     * @return returns true if the element has been deleted otherwise false.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;

        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId().equals(id)) {
                storage.delete(i);
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * The method returns an item from the container.
     * @param id - id of the desired element.
     * @return returns an item from the container.
     */
    @Override
    public T findById(String id) {
        T result = null;

        for (T elem : storage) {
            if (elem.getId().equals(id)) {
                result = elem;
                break;
            }
        }

        return result;
    }
}