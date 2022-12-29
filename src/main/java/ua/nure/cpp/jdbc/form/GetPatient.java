package ua.nure.cpp.jdbc.form;

public class GetPatient {

    int code_patient;

    public GetPatient(int code_patient) {
        this.code_patient = code_patient;
    }

    public GetPatient() {
    }

    public int getCode_patient() {
        return code_patient;
    }

    public void setCode_patient(int code_patient) {
        this.code_patient = code_patient;
    }
}
