package ru.job4j.search;

import java.util.LinkedList;

/**
 * PriorityQueue.
 * @author Ivan Belyaev
 * @since 24.04.2018
 * @version 1.0
 */
public class PriorityQueue {
    /** Task list. */
     private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method adds the task to the list according to its priority.
     * @param task - added task.
     */
    public void put(Task task) {
        int i = 0;

        for (; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() > task.getPriority()) {
                break;
            }
        }

        tasks.add(i, task);
    }

    /**
     * The method returns the highest priority task.
     * @return returns the highest priority task.
     */
    public Task take() {
        return this.tasks.poll();
    }
}