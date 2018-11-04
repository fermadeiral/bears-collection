package ru.job4j.oop;

/**
 * Class Doctor Решение задачи 1. Реализация профессий в коде [#6837]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 01.12.2017
 */
public class Doctor extends Profession {

    private double workExpirience;
    private Address address;

    /**
     * Конструктор класса.
     */
    public Doctor(String name, String specialization, Education education, double workExpirience, Address address) {
        super(name, specialization, education);
        this.workExpirience = workExpirience;
        this.address = address;
    }

    /**
     * геттер.
     * @return информация о стаже работы.
     */
    public double getWorkExpirience() {
        return workExpirience;
    }

    /**
     * сеттер.
     * @param workExpirience стаж работы.
     */
    public void setWorkExpirience(double workExpirience) {
        this.workExpirience = workExpirience;
    }

    /**
     * геттер.
     * @return информация об адресе проживания.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * сеттер.
     * @param address информация об адресе проживания.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Метод проводит ежедневный обход пациентов.
     * @param patients пациенты.
     * @return Возвращает отчет.
     */
    DayReport checkPatientsDaily(Patient[] patients) {
        DayReport dayReport = new DayReport();
        return dayReport;
    }

    /**
     * Метод проводит опрос пациента.
     * @param patient пациент.
     * @param patientCard карточка пациента.
     * @return Возвращает дополненную карточку пациента.
     */
    PatientCard conductSurvey(Patient patient, PatientCard patientCard) {
        // добавляет информацию в карточку пациента
        return patientCard;
    }

    /**
     * Метод назначает лечение.
     * @param patientCard карточка пациента.
     * @return Возвращает способ лечения.
     */
    Therapy diagnose(PatientCard patientCard) {
        // выбираем вид лечения
        Therapy therapy = new Therapy();
        return therapy;
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Address {
        // информация об адресе проживания
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class DayReport {
        // отчет о рабочем дне
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Patient {
        // информация о пациенте
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class PatientCard {
        // карточка пациента
    }

    /**
     * Class Вспомогательный класс
     * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
     * @since 01.12.2017
     */
    private class Therapy {
        // способ лечения
    }

}
