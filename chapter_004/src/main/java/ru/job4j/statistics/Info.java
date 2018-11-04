package ru.job4j.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Info | Task Solution: Collection statistics [#45889]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 08.10.2018
 */
class Info {

    private int added = 0;
    private int changed = 0;
    private int deleted = 0;
    private Map<Integer, User> currentConverted = new HashMap<>();


    public int getAdded() {
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public int getDeleted() {
        return deleted;
    }

    /**
     * Compare Lists.
     * @param previous List of elements.
     * @param current  Possibly modified list of elements.
     * @return Lists compare information.
     */
    public Info compare(List<User> previous, List<User> current) {
        convertData(current);
        deleted = getDeletedElements(previous, currentConverted);
        changed = getChangedElements(previous, currentConverted);
        added = getAddedElements(previous, current);
        return this;
    }

    private Map<Integer, User> convertData(List<User> current) {
        for (User user : current) {
            currentConverted.put(user.getId(), user);
        }
        return currentConverted;
    }

    /**
     * Calculate deleted elements
     * @param previous List of elements.
     * @param currentHM  Possibly modified map of elements.
     * @return Number of deleted elements.
     */
    private int getDeletedElements(List<User> previous, Map<Integer, User> currentHM) {
        int count = 0;
        for (User prevUser : previous) {
            if (currentHM.get(prevUser.getId()) == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculate changed elements
     * @param previous List of elements.
     * @param currentHM  Possibly modified map of elements.
     * @return Number of changed elements.
     */
    private int getChangedElements(List<User> previous, Map<Integer, User> currentHM) {
        int count = 0;
        for (User prevUser : previous) {
            User temp = currentHM.get(prevUser.getId());
            if ((temp != null) && (!temp.getName().equals(prevUser.getName()))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculate added elements
     * @param previous List of elements.
     * @param current  Possibly modified list of elements.
     * @return Number of added elements.
     */
    private int getAddedElements(List<User> previous, List<User> current) {
        return current.size() - previous.size() - this.getDeletedElements(previous, currentConverted);
    }
}