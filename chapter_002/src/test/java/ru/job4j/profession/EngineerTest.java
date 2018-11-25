package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * EngineerTest.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class EngineerTest {
    /**
     * Test for the developDetail method.
     */
    @Test
    public void whenDevelopDetailThenIvanDevelopWheel() {
        Engineer engineer = new Engineer("Иван", "ТГТУ", 5, "ПромТехСтрой");
        Order orderDetail = new Order("колесо");
        String methodReturns = engineer.developDetail(orderDetail);
        String expected = "Инженер Иван разрабатывает колесо.";
        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for the getReport method.
     */
    @Test
    public void whenGetReportThenDenisGetReport() {
        Engineer engineer = new Engineer("Денис", "ТГТУ", 5, "ПромТехСтрой");
        String methodReturns = engineer.getReport();
        String expected = "Инженер Денис делает отчет.";
        assertThat(methodReturns, is(expected));
    }
}
