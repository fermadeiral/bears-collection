package ru.job4j.departments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Organization.
 * @author Ivan Belyaev
 * @since 23.04.2018
 * @version 1.0
 */
public class Organization {
    /** All departments of the organization. */
    private Set<String> allDepartments;

    /**
     * The constructor creates the object Organization.
     * @param givenDepartments - epartments that are given (perhaps not all).
     */
    public Organization(List<String> givenDepartments) {
        allDepartments = addMissingDepartments(givenDepartments);
    }

    /**
     * The method forms a complete departmental structure and returns it sorted in ascending order.
     * @return returns a complete list of departments sorted in ascending order.
     */
    public List<String> ascendingSort() {
        Set<String> sortedDepartments = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        sortedDepartments.addAll(allDepartments);

        return new ArrayList<>(sortedDepartments);
    }

    /**
     * The method forms a complete departmental structure and returns it sorted in descending order.
     * @return returns a complete list of departments sorted in descending order.
     */
    public List<String> descendingSort() {
        Set<String> sortedDepartments = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                int i = 0;
                for (i = 0; i < o1.length() && i < o2.length(); i++) {
                    result = Character.compare(o2.charAt(i), o1.charAt(i));
                    if (result != 0) {
                        break;
                    }
                }

                if (result == 0 && i < o1.length()) {
                    result = 1;
                }

                if (result == 0 && i < o2.length()) {
                    result = -1;
                }

                return result;

            }
        });

        sortedDepartments.addAll(allDepartments);

        return new ArrayList<>(sortedDepartments);
    }

    /**
     * The method returns a complete set of departments.
     * @param givenDepartments - departments that are given (perhaps not all).
     * @return returns a complete set of departments.
     */
    private Set<String> addMissingDepartments(List<String> givenDepartments) {
        Set<String> allDepartments = new HashSet<>();

        for (String branch : givenDepartments) {
            StringBuilder department = new StringBuilder();
            for (String codeDepartment : branch.split("\\\\")) {
                department.append(codeDepartment);
                allDepartments.add(department.toString());
                department.append("\\");
            }
        }

        return allDepartments;
    }
}
