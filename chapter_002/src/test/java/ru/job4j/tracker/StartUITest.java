package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 14.12.2017
 */
public class StartUITest {
    // Поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // Буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    // Выносим разделитель строк в отдельную переменную
    private final String separator = System.lineSeparator();
    // Выносим вывод меню в отдельную переменную
    private final String menu = new StringBuilder()
            .append("0. Add new item").append(separator)
            .append("1. Show all items").append(separator)
            .append("2. Edit item").append(separator)
            .append("3. Delete item").append(separator)
            .append("4. Find item by Id").append(separator)
            .append("5. Find items by name").append(separator)
            .append("6. Exit Program").append(separator)
            .toString();

    /**
     * Метод печатает информацию о заявке в строку.
     * @param item Заявка.
     * @return Информация о заявке.
     */
    private String showOneItem(Item item) {
        return new StringBuilder()
                .append("Name:    " + item.getName()).append(separator)
                .append("Id:      " + item.getId()).append(separator)
                .append("Desc:    " + item.getDesc()).append(separator)
                .append("Created: " + item.getCreate()).append(separator)
                .toString();
    }

    @Before
    public void loadOutput() {
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    /**
     * Test createItems.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        // создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * Test edit.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name", "desc", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Test delete.
     */
    @Test
    public void whenDeleteThenTrackerHasNoDeletedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name", "desc", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is((Item) null));
    }

    /**
     * Test showAllItems.
     */
    @Test
    public void whenAddTwoItemsThenShowTwoItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Name", "desc", 123L);
        Item item2 = new Item("Name 2", "desc", 123L);
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String result = new StringBuilder()
                .append(menu)
                .append("------------ Showing all tasks ------------")
                .append(separator)
                .append(this.showOneItem(item1))
                .append("------------").append(separator)
                .append(this.showOneItem(item2))
                .append("------------").append(separator)
                .append(menu)
                .toString();
        assertThat(new String(out.toByteArray()), is(result));
    }

    /**
     * Test findById.
     */
    @Test
    public void whenAddOneItemThenShowItemById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Name", "desc", 123L);
        tracker.add(item1);
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        String result = new StringBuilder()
                .append(menu)
                .append(this.showOneItem(item1))
                .append(menu)
                .toString();
        assertThat(new String(out.toByteArray()), is(result));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenAddOneItemThenShowItemByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Name", "desc", 123L);
        tracker.add(item1);
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
        new StartUI(input, tracker).init();
        String result = new StringBuilder()
                .append(menu)
                .append(this.showOneItem(item1))
                .append("------------")
                .append(separator)
                .append(menu)
                .toString();
        assertThat(new String(out.toByteArray()), is(result));
    }
}