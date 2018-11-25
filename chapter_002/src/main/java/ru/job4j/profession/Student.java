package ru.job4j.profession;

/**
 * Student.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class Student {
    /** Static field to number the next student ID. */
    private static int nextStudentCardId = 1;

    /** The field contains the name of the student. */
    private String name;
    /** The field contains the group number. */
    private int groupId;
    /** Field contains the number of the student card. */
    private int studentCardId;

    /**
     * The constructor creates the object Student.
     * @param name - the name of the student.
     * @param groupId - the group number.
     */
    public Student(String name, int groupId) {
        this.name = name;
        this.groupId = groupId;
        this.studentCardId = this.calcStudentCardId();
    }

    /**
     * The method calculates the number of the next student ID.
     * @return returns the number the next student ID.
     */
    private int calcStudentCardId() {
        return Student.nextStudentCardId++;
    }

    /**
     * The method returns the name of the student.
     * @return returns the name of the student.
     */
    public String getName() {
        return this.name;
    }
}
