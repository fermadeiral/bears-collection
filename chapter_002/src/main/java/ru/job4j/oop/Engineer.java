package ru.job4j.oop;

/**
 * Class Engineer Решение задачи 1. Реализация профессий в коде [#6837]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.12.2017
 */
public class Engineer extends Profession {

    /**
     * Конструктор класса.
     */
    public Engineer(String name, String specialization, Education education) {
        super(name, specialization, education);
    }

    /**
     * Метод выполняет работы по проекту.
     * @param sourceProject исходные данные к работе.
     * @return выполненный проект
     */
    Project makeProject(SourceProject sourceProject) {
        Project project = new Project();
        sourceProject.getSourceProjectData();
        // do some job with sourceProject
        return project;
    }

    /**
     * Метод выполняет собеседование с кандидатом.
     * @param candidate кандидат.
     * @return объект candidate с информацией об успешности
     * прохождения интервью
     */
    Candidate interview(Candidate candidate) {
        // проведение интервью с кандидатом прошло успешно
        candidate.setSuccess(true);
        return candidate;
    }

    /**
     * Метод отправляет инженера в отпуск.
     * @param days количество отпускных дней.
     * @return Возвращает информациолнную строку
     */
    String takeVacation(int days) {
        return this.getName() + " goes on vacation for " + days + " days.";
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Project {
        String projectData;

        /**
         * сеттер.
         * @param projectData информация по выполненному проекту.
         */
        public void setProjectData(String projectData) {
            this.projectData = projectData;
        }
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class SourceProject {
        String sourceProjectData;

        /**
         * геттер.
         * @return информация с исходными данными
         */
        public String getSourceProjectData() {
            return sourceProjectData;
        }
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Candidate {
        String name = "";
        boolean success = false;

        /**
         * Конструктор класса.
         */
        public Candidate(String name) {
            this.name = name;
        }

        /**
         * сеттер.
         * @param success успешность прохождения интервью.
         */
        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
}


