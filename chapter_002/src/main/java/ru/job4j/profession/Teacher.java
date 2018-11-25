package ru.job4j.profession;

/**
 * Teacher.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class Teacher extends Profession {
    /** The field contains the name of the school. */
    private String school;

    /**
     * The constructor creates the object Teacher.
     * @param name - the name of the specialist.
     * @param diploma - diploma.
     * @param experience - experience in years.
     * @param school - the name of the school.
     */
    public Teacher(String name, String diploma, int experience, String school) {
        super(name, diploma, experience);
        this.school = school;
    }

    /**
     * The method returns the name of the school.
     * @return returns the name of the school.
     */
    public String getSchool() {
        return this.school;
    }

    /**
     * The method simulates the lectures.
     * @param group - the array contains a group of students.
     * @return returns the actions of the teacher.
     */
    public String teach(Student[] group) {
        return "Учитель " + this.getName() + " читает лекцию группе из " + group.length + " человек.";
    }

    /**
     * The method simulates a test of student knowledge.
     * @param student - the student.
     * @return returns the actions of the teacher.
     */
    public String askStudent(Student student) {
        return "Учитель " + this.getName() + " задает вопрос " + student.getName() + ".";
    }
}
