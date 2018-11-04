package ru.job4j.tracker;

/**
 * Class Item 2. Реализовать класс Tracker [#396]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 04.12.2017
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private String[] comments;
    private long create;

    /**
     * Конструктор.
     */
    public Item(String name, String desc, long create) {
        this.name = name;
        this.desc = desc;
        this.create = create;
    }

    /**
     * Getter.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter.
     * @return desc.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Getter.
     * @return create.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Getter.
     * @return comments.
     */
    public String[] getComments() {
        return this.comments;
    }

    /**
     * Getter.
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter.
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter.
     * @param desc description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Setter.
     * @param create create.
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * Setter.
     * @param comments comments.
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * Setter.
     * @param id id.
     */
    public void setId(String id) {
        this.id = id;
    }
}
