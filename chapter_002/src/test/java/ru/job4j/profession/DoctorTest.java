package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DoctorTest.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class DoctorTest {
    /**
     * Test for the treat method.
     */
    @Test
    public void whenTreatThenIvanTreatKatya() {
        Doctor doctor = new Doctor("Иван", "ТГМА", 5, "1-я ГорБольница");
        Person person = new Person("Катя");
        String methodReturns = doctor.treat(person);
        String expected = "Доктор Иван лечит Катя.";
        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the diagnose method.
     */
    @Test
    public void whenDiagnoseThenOlgaDiagnoseRoma() {
        Doctor doctor = new Doctor("Оля", "ТГМА", 5, "1-я ГорБольница");
        Person person = new Person("Рома");
        String methodReturns = doctor.diagnose(person);
        String expected = "Доктор Оля ставит диагноз Рома.";
        assertThat(methodReturns, is(expected));
    }
}
