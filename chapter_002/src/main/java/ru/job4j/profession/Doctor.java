package ru.job4j.profession;

/**
 * Doctor.
 * @author Ivan Belyaev
 * @since 12.09.2017
 * @version 1.0
 */
public class Doctor extends Profession {
    /** The field contains the name of the hospital. */
    private String hospital;

    /**
     * The constructor creates the object Doctor.
     * @param name - the name of the specialist.
     * @param diploma - diploma.
     * @param experience - experience in years.
     * @param hospital - the name of the hospital.
     */
    public Doctor(String name, String diploma, int experience, String hospital) {
        super(name, diploma, experience);
        this.hospital = hospital;
    }

    /**
     * The method returns the name of the hospital.
     * @return returns the name of the hospital.
     */
    public String getHospital() {
        return this.hospital;
    }

    /**
     * The method simulates the treatment of the patient.
     * @param person - the patient.
     * @return returns the actions of the doctor.
     */
    public String treat(Person person) {
        return "Доктор " + this.getName() + " лечит " + person.getName() + ".";
    }

    /**
     * The method simulates the diagnosis.
     * @param person - the patient.
     * @return returns the actions of the doctor.
     */
    public String diagnose(Person person) {
        return "Доктор " + this.getName() + " ставит диагноз " + person.getName() + ".";
    }
}
