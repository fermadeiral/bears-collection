package ru.job4j.oop;

/**
 * Class Profession Решение задачи 1. Реализация профессий в коде [#6837]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.12.2017
 */
public class Profession {
    String name;
    String specialization;
    Education education;

    /**
     * Дефолтный конструктор класса.
     */
    public Profession() { }

    /**
     * Конструктор класса.
     */
    public Profession(String name, String specialization, Education education) {
        this.name = name;
        this.specialization = specialization;
        this.education = education;
    }

    /**
     * геттер.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * геттер.
     * @return специализация
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * геттер.
     * @return информация об образовании
     */
    public Education getEducation() {
        return education;
    }
}
