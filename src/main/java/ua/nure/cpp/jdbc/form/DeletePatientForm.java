package ua.nure.cpp.jdbc.form;

public class DeletePatientForm {

    private int codePatient;

    public DeletePatientForm(int codePatient) {
        this.codePatient = codePatient;
    }

    public DeletePatientForm() {
    }

    public int getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(int codePatient) {
        this.codePatient = codePatient;
    }
}
