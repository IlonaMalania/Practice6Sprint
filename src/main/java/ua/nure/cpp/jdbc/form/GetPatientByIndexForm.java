package ua.nure.cpp.jdbc.form;

public class GetPatientByIndexForm {

    private int codePatient;

    public GetPatientByIndexForm(int codePatient) {
        this.codePatient = codePatient;
    }

    public GetPatientByIndexForm() {
    }

    public int getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(int codePatient) {
        this.codePatient = codePatient;
    }

}
