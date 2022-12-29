package ua.nure.cpp.jdbc.dao.connection;

import ua.nure.cpp.jdbc.entity.AllDoctors;

import java.sql.SQLException;
import java.util.List;

public interface DoctorsDao {

    void add(AllDoctors doctors) throws SQLException;

    AllDoctors getByIndex(int index) throws SQLException;

    List<AllDoctors> getAll() throws SQLException;

    void update(AllDoctors doctors) throws SQLException;

    void delete(AllDoctors doctors) throws SQLException;
}
