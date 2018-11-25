package ru.job4j.profession;

/**
 * Engineer.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class Engineer extends Profession {
    /** The field contains the name of the company. */
    private String company;

    /**
     * The constructor creates the object Engineer.
     * @param name - the name of the specialist.
     * @param diploma - diploma.
     * @param experience - experience in years.
     * @param company - the name of the company.
     */
    public Engineer(String name, String diploma, int experience, String company) {
        super(name, diploma, experience);
        this.company = company;
    }

    /**
     * The method returns the name of the company.
     * @return returns the name of the company.
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * The method simulates the design details.
     * @param order - order detail.
     * @return returns the actions of the engineer.
     */
    public String developDetail(Order order) {
        return "Инженер " + this.getName() + " разрабатывает " + order.getDetailName() + ".";
    }

    /**
     * The method simulates the preparation of a report.
     * @return returns the actions of the engineer.
     */
    public String getReport() {
        return "Инженер " + this.getName() + " делает отчет.";
    }
}
