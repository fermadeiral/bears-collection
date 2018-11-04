package ru.job4j.tracker;

/**
 * Class BaseAction Рефакторинг - Перенести общие методы в абстрактный класс [#790]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.01.2018
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    /**
     * Конструктор.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Метод идентифицирует соответствие действия определенному пункту меню.
     * @return Порядковый номер.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Метод формирует порядковый номер и описание действия в меню пользователя.
     * @return Порядковый номер и описание действия.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}