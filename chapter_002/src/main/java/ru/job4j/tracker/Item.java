package ru.job4j.tracker;

/**
 * Item.
 * @author Ivan Belyaev
 * @since 14.09.2017
 * @version 1.0
 */
public class Item {
    /** The field contains the counter reviews. */
    private int commentsCounter = 0;
    /** The maximum number of comments. */
    private static final int MAX_COMMENTS = 10;

    /** The name of the application. */
    private String name;
    /** The description of the application. */
    private String desctiption;
    /**  Created date. */
    private long create;
    /** Array storage review. */
    private String[] comments = new String[MAX_COMMENTS];
    /** Field contains a unique identifier. */
    private String id;

    /**
     * The constructor creates the object Item.
     * @param name - the name of the application.
     * @param desctiption - the description of the application.
     * @param create - created date.
     */
    public Item(String name, String desctiption, long create) {
        this.name = name;
        this.desctiption = desctiption;
        this.create = create;
    }

    /**
     * The method returns the name of the application.
     * @return returns the name of the application.
     */
    public String getName() {
        return this.name;
    }

    /**
     * The method returns the description of the application.
     * @return returns the description of the application.
     */
    public String getDesctiption() {
        return this.desctiption;
    }

    /**
     * The method returns created date of the application.
     * @return returns created date of the application.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * The method returns array storage review.
     * @return returns array storage review.
     */
    public String[] getComments() {
        String[] result = new String[commentsCounter];
        for (int index = 0; index < commentsCounter; index++) {
            result[index] = comments[index];
        }
        return result;
    }

    /**
     * The method returns the unique identifier.
     * @return returns the unique identifier.
     */
    public String getId() {
        return this.id;
    }

    /**
     * The method sets the new name of the application.
     * @param name - new name of the application.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method sets the new description of the application.
     * @param desctiption - new description of the application.
     */
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    /**
     * The method sets the new created date of the application.
     * @param create - new created date of the application.
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * The method sets the new unique identifier date of the application.
     * @param id - new the unique identifier of the application.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The method adds a comment to the ticket.
     * @param newComment - new comment to the ticket.
     */
    public void addComment(String newComment) {
        if (commentsCounter < MAX_COMMENTS) {
            comments[commentsCounter++] = newComment;
        }
    }
}
