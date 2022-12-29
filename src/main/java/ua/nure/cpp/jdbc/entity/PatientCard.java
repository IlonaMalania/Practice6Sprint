package ua.nure.cpp.jdbc.entity;

public class PatientCard {
    private int codePatient;
    private String name;
    private String dateOfBirth;
    private int gender;
    private String address;
    private String phoneNumber;
    private int familyDoctor;

    public PatientCard() {
    }

    public PatientCard(int codePatient, String name, String dateOfBirth, int gender, String address, String phoneNumber, int familyDoctor) {
        this.codePatient = codePatient;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.familyDoctor = familyDoctor;
    }

    public int getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(int codePatient) {
        this.codePatient = codePatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFamilyDoctor() {
        return familyDoctor;
    }

    public void setFamilyDoctor(int familyDoctor) {
        this.familyDoctor = familyDoctor;
    }

    @Override
    public String toString() {
        return "PatientCard{" +
                "codePatient=" + codePatient +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", familyDoctor=" + familyDoctor +
                '}';
    }
}
