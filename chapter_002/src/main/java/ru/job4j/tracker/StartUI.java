package ru.job4j.tracker;

/**
 * Class StartUI Реализация задания [#784]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.12.2017
 */
public class StartUI {

    private int[] range;
    private final Input input;
    private final Tracker tracker;

    /**
     * Метод формирует диапазон корректных значений для выбора в меню.
     * @param userActionsSize количество пунктов в меню
     */
    private void setRange(int userActionsSize) {
        range = new int[userActionsSize];
        for (int i = 0; i < userActionsSize; i++) {
            range[i] = i;
        }
    }

    /**
     * Конструктор.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод реализует основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        setRange(menu.getActionsSize());
        int userChoiceKey;
        do {
            menu.show();
            userChoiceKey = input.ask("Select: ", range);
            menu.select(userChoiceKey);
        } while (userChoiceKey != 6);
    }

    /**
     * Запуск программы.
     * @param args args.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}