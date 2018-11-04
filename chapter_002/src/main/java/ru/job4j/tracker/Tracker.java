package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class Tracker Реализовать класс Tracker [#396]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 04.12.2017
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Метод реализует добавление заявок.
     * @param item заявка.
     * @return Добавленная заявка.
     */
    public Item add(Item item) {
        item.setId(this.generatedId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный id для заявки.
     * @return id.
     */
    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод реализует редактирование заявок.
     * @param item отредактированная заявка.
     */
    public void update(Item item) {
        Item updatingItem = this.findById(item.getId());
        updatingItem.setName(item.getName());
        updatingItem.setDesc(item.getDesc());
        updatingItem.setCreate(item.getCreate());
        updatingItem.setComments(item.getComments());
    }

    /**
     * Метод реализует удаление заявок.
     * @param item заявка.
     */
    public void delete(Item item) {
        items.remove(item);
    }

    /**
     * Метод реализует получение списка всех заявок.
     * @return Все заявки.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод реализует получение списка заявок по имени.
     * @param key имя заявки.
     * @return Список найденных заявок.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        // создаем массив с найденными элементами
        for (Item item : items) {
            if ((item.getName().equals(key))) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод реализует получение заявки по id.
     * @param id id заявки.
     * @return Найденный элемент.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if ((item != null) && (item.getId().equals(id))) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Метод выводит заявку на экран.
     * @param id id заявки.
     */
    public void showItemById(String id) {
        Item item = this.findById(id);

        System.out.println("Name:    " + item.getName());
        System.out.println("Id:      " + item.getId());
        System.out.println("Desc:    " + item.getDesc());
        System.out.println("Created: " + item.getCreate());
        if (item.getComments() != null) {
            String[] comments = item.getComments();
            System.out.println("Comments for this item:");
            for (String comment : comments) {
                System.out.println(comment);
            }
        }
    }
}