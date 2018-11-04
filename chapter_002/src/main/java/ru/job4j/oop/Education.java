package ru.job4j.oop;

/**
 * Class Вспомогательный класс
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.12.2017
 */
public class Education {

    private String schoolName;
    private String faculty;
    private boolean done;

    /**
     * Конструктор класса.
     */
    public Education(String schoolName, String faculty, boolean done) {
        this.schoolName = schoolName;
        this.faculty = faculty;
        this.done = done;
    }
}
