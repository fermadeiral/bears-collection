package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MenuTracker Реализовать события на внутренних классах. [#787]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 25.12.2017
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Геттер.
     */
    public int getActionsSize() {
        return actions.size();
    }

    /**
     * Конструктор.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод формирует меню и предоставляет выбор пользователю.
     */
    public void fillActions() {
        this.actions.add(this.new AddItem(0, "Add new item"));
        this.actions.add(new MenuTracker.ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(this.new DeleteItem(3, "Delete item"));
        this.actions.add(new MenuTracker.FindItemById(4, "Find item by Id"));
        this.actions.add(new MenuTracker.FindItemsByName(5, "Find items by name"));
        this.actions.add(this.new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод выполняет действие, выбранное пользователем.
     */
    public void select(int key) {
        actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит меню на экран.
     */
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Class AddItem Реализует добавление новый заявки в трекер.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new task ------------");
            String name = input.ask("Enter task name: ");
            String desc = input.ask("Enter task description: ");
            long create = System.currentTimeMillis();
            Item item = new Item(name, desc, create);
            tracker.add(item);
            System.out.println();
            System.out.println("------------ New task ------------");
            tracker.showItemById(item.getId());
        }
    }

    /**
     * Class ShowItems Реализует вывод на экран всех заявок из трекера.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Showing all tasks ------------");
            for (Item item : tracker.findAll()) {
                tracker.showItemById(item.getId());
                System.out.println("------------");
            }
        }
    }

    /**
     * Class DeleteItem Реализует удаление заявки из трекера.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item deletingItem = tracker.findById(input.ask("Enter deleting item id: "));
            System.out.println("------------ Deleting task with id " + deletingItem.getId() + "------------");
            tracker.delete(deletingItem);
        }
    }

    /**
     * Class FindItemById Реализует поиск заявки по Id.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public static class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.showItemById(input.ask("Enter finding item id: "));
        }
    }

    /**
     * Class FindItemsByName Реализует поиск заявки (заявок) по имени.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public static class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> result = new ArrayList<>();
            result.addAll(tracker.findByName(input.ask("Enter finding item (items) name: ")));
            for (Item item : result) {
                tracker.showItemById(item.getId());
                System.out.println("------------");
            }
        }
    }

    /**
     * Class ExitProgram Реализует выход из программы.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }

    /**
     * Class EditItem Реализует редактирование заявки.
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 25.12.2017
     */
    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item editingItem = tracker.findById(input.ask("Enter editing item's id: "));
            System.out.println("------------ Updating task with id " + editingItem.getId() + "------------");
            editingItem.setName(input.ask("Enter new task's name: "));
            editingItem.setDesc(input.ask("Enter new task's description: "));
            tracker.update(editingItem);
            System.out.println("Task was update");
            tracker.showItemById(editingItem.getId());
        }
    }
}