package ua.nure.cpp.jdbc.entity;


public class AllDoctors {

    private int code;
    private String name;
    private int specialty;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecialty() {
        return specialty;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "AllDoctors{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", specialty=" + specialty +
                '}';
    }
}
