package ru.job4j.search;

/**
 * Task.
 * @author Ivan Belyaev
 * @since 24.04.2018
 * @version 1.0
 */
public class Task {
    /** Task description. */
    private String desc;
    /** Priority of the task. */
    private int priority;

    /**
     * The constructor creates the object Task.
     * @param desc -task description.
     * @param priority - priority of the task.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * The method returns a description of the task.
     * @return returns a description of the task.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * The method returns the priority of the task.
     * @return returns the priority of the task.
     */
    public int getPriority() {
        return priority;
    }
}