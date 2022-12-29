package ua.nure.cpp.jdbc.dao.collection;

import ua.nure.cpp.jdbc.dao.connection.PatientDao;
import ua.nure.cpp.jdbc.entity.PatientCard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CollectionLDAO implements PatientDao {

    private static List<PatientCard> patients = new ArrayList<>();

    static {
        patients.add(new PatientCard(1, "Malania Ilona", "2004-11-05", 1, "Ave Nauky 2, Kharkiv", "380954555334", 1));
        patients.add(new PatientCard(2, "Dobrev Nina", "1987-03-13", 1, ", Kharkiv", "+380995642322", 2));
        patients.add(new PatientCard(3, "Tereshenko Katerina", "2002-03-11", 1, "Saltovka 33", "38099244233", 4));
    }
    @Override
    public void add(PatientCard patient) throws SQLException {

        patients.add(patient);
    }

    @Override
    public PatientCard getByIndex(int index) throws SQLException {
        for(PatientCard patientCard: patients){
            if(patientCard.getCodePatient() == index){
                return patientCard;
            }
        }
        return new PatientCard();
    }

    @Override
    public List<PatientCard> getAll() throws SQLException {
        return patients;
    }

    @Override
    public void update(PatientCard patientCard) throws SQLException {

    }

    @Override
    public void delete(PatientCard patientCard) throws SQLException {
        patients = patients.stream().filter(patient -> patient.getCodePatient() != patientCard.getCodePatient())
                .collect(Collectors.toList());
    }

}
