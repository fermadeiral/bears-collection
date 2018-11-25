package ru.job4j.profession;

/**
 * Profession.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public abstract class Profession {
    /** Field contains the name. */
    private String name;
    /** Field contains the diploma. */
    private String diploma;
    /** The field contains experience in years. */
    private int experience;

    /**
     * Constructor for use in subclasses.
     * @param name - the name of the specialist.
     * @param diplama - diploma.
     * @param experience - experience in years.
     */
    public Profession(String name, String diplama, int experience) {
        this.name = name;
        this.diploma = diplama;
        this.experience = experience;
    }

    /**
     * The method returns the name of the specialist.
     * @return returns the name of the specialist.
     */
    public String getName() {
        return this.name;
    }

    /**
     * The method returns diploma.
     * @return returns diploma.
     */
    public String getDiploma() {
        return this.diploma;
    }

    /**
     * The method returns experience.
     * @return returns experience in years.
     */
    public int getExperience() {
        return this.experience;
    }
}
