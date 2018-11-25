package ru.job4j.departments;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * OrganizationTest.
 * @author Ivan Belyaev
 * @since 23.04.2018
 * @version 1.0
 */
public class OrganizationTest {
    /**
     * Test for ascendingSort method.
     */
    @Test
    public void whenAscendingSortThenFullListSortedInAscendingOrder() {
        List<String> list = new ArrayList<>();
        Collections.addAll(
                list,
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        );

        Organization organization = new Organization(list);

        List<String> methodReturns = organization.ascendingSort();
        List<String> expected = new ArrayList<>();
        Collections.addAll(
                expected,
                "K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        );

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for descendingSort method.
     */
    @Test
    public void whenDescendingSortThenFullListSortedInDescendingOrder() {
        List<String> list = new ArrayList<>();
        Collections.addAll(
                list,
                "K1\\SK1\\SSK1", "K1\\SK2\\SSK1",
                "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K3\\SK1"
        );

        Organization organization = new Organization(list);

        List<String> methodReturns = organization.descendingSort();
        List<String> expected = new ArrayList<>();
        Collections.addAll(
                expected,
                "K3", "K3\\SK1",
                "K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK2\\SSK1", "K1\\SK1", "K1\\SK1\\SSK1"
        );

        assertThat(methodReturns, is(expected));
    }
}
