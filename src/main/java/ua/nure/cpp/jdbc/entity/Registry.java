package ua.nure.cpp.jdbc.entity;

public class Registry {

    private String dateTime;
    private int doctor;
    private int patient;
    private int id;

    public Registry(String dateTime, int doctor, int patient, int id) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.id = id;
    }

    public Registry() {
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "dateTime='" + dateTime + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", id=" + id +
                '}';
    }
}
