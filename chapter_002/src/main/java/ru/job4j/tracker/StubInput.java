package ru.job4j.tracker;

/**
 * Class StubInput Реализация тестового ввода данных
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 12.12.2017
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    /**
     * Конструктор.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод реализует запрос данных для тестирования.
     * @param question Текст запроса.
     * @return результат запроса.
     */
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        return key;
    }
}
