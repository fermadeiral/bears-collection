package ru.job4j.statistics;

import java.util.List;

/**
 * Class Info | Task Solution: Collection statistics [#45889]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 08.10.2018
 */
class Info {

    private int added = 0;
    private int changed = 0;
    private int deleted = 0;

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
        changed = getDeletedElements(previous, current);
        added = getAddedElements(previous, current);
        deleted = getChangedElements(previous, current);
        return this;
    }

    /**
     * Calculate added elements
     * @param previous List of elements.
     * @param current  Possibly modified list of elements.
     * @return Number of added elements.
     */
    int getAddedElements(List<User> previous, List<User> current) {
        return current.size() - previous.size() - this.getDeletedElements(previous, current);
    }

    /**
     * Calculate changed elements
     * @param previous List of elements.
     * @param current  Possibly modified list of elements.
     * @return Number of changed elements.
     */
    int getChangedElements(List<User> previous, List<User> current) {
        int count = 0;
        for (User prevUser : previous) {
            for (User currUser : current) {
                if (prevUser.equals(currUser)) {
                    break;
                } else if (prevUser.getId() == currUser.getId()) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * Calculate deleted elements
     * @param previous List of elements.
     * @param current  Possibly modified list of elements.
     * @return Number of deleted elements.
     */
    int getDeletedElements(List<User> previous, List<User> current) {
        int count = 0;
        boolean isDeleted = false;
        for (User prevUser : previous) {
            for (User currUser : current) {
                if (prevUser.getId() == currUser.getId()) {
                    isDeleted = false;
                    break;
                } else {
                    isDeleted = true;
                }
            }
            if (isDeleted) {
                count++;
            }
        }
        return count;
    }
}