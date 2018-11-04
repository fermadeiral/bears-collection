package ru.job4j.oop;

/**
 * Class Teacher Решение задачи 1. Реализация профессий в коде [#6837]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.12.2017
 */
public class Teacher extends Profession {

    private double workExpirience;
    private double salary;

    /**
     * Конструктор класса.
     */
    public Teacher(String name,
                   String specialization,
                   Education education,
                   double workExpirience, double salary) {
        super(name, specialization, education);
        this.workExpirience = workExpirience;
        this.salary = salary;
    }

    /**
     * геттер.
     * @return информация о стаже работы.
     */
    public double getWorkExpirience() {
        return workExpirience;
    }

    /**
     * сеттер.
     * @param workExpirience стаж работы.
     */
    public void setWorkExpirience(double workExpirience) {
        this.workExpirience = workExpirience;
    }

    /**
     * геттер.
     * @return информация о зарплате.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * сеттер.
     * @param salary заработная плата.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Метод учит студента.
     * @param student студент.
     * @return Возвращает результат обучения (оценку).
     */
    Estimate teach(Student student) {
        // возвращает информацию о результате обучения студента
        // в виде оценки
        Estimate estimate = new Estimate();
        return estimate;
    }

    /**
     * Метод корректирует учебную программу.
     * @param requirements требования Министерства образования.
     * @return возвращает скорректированную учебную программу.
     */
    StudyProgram correctStudyProgram(EducationMinistryRequirements requirements) {
        StudyProgram studyProgram = new StudyProgram();
        // корректируем учебную программу
        return studyProgram;
    }

    /**
     * Метод замещает коллегу.
     * @param teacher коллега.
     */
    void replaceColleaugue(Teacher teacher) {
        // заместить коллегу
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Estimate {
        // оценка работы студента
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Student {
        // информация о студенте
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class StudyProgram {
        // информация о текущей учебной программе
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class EducationMinistryRequirements {
        // информация о требованиях Министерства образования
        // к разработке учебной программы
    }
}