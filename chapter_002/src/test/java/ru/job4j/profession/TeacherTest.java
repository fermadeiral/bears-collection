package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TeacherTest.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class TeacherTest {
    /**
     * Test for the teach method.
     */
    @Test
    public void whenTeachThenSlavaTeachThreeStudent() {
        Teacher teacher = new Teacher("Вячеслав", "ТГУ", 5, "Средняя школа");
        Student[] students = new Student[3];
        String methodReturns = teacher.teach(students);
        String expected = "Учитель Вячеслав читает лекцию группе из 3 человек.";
        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the askStudent method.
     */
    @Test
    public void whenAskStudentThenElenaAskDima() {
        Teacher teacher = new Teacher("Елена", "ТГУ", 5, "Средняя школа");
        Student student = new Student("Дима", 212);
        String methodReturns = teacher.askStudent(student);
        String expected = "Учитель Елена задает вопрос Дима.";
        assertThat(methodReturns, is(expected));
    }
}
