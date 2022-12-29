package ua.nure.cpp.jdbc.dao.connection;

import ua.nure.cpp.jdbc.entity.PatientCard;

import java.sql.SQLException;
import java.util.List;

public interface PatientDao {

    void add(PatientCard patient) throws SQLException;

    PatientCard getByIndex(int index) throws SQLException;

    List<PatientCard> getAll() throws SQLException;

    void update(PatientCard patientCard) throws SQLException;

    void delete(PatientCard patientCard) throws SQLException;
}
