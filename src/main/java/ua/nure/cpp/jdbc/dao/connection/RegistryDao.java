package ua.nure.cpp.jdbc.dao.connection;


import ua.nure.cpp.jdbc.entity.Registry;

import java.sql.SQLException;
import java.util.List;

public interface RegistryDao {

    void add(Registry appointment) throws SQLException;

    Registry getByIndex(int index) throws SQLException;

    List<Registry> getAll() throws SQLException;

    void update(Registry appointment) throws SQLException;

    void delete(Registry appointment) throws SQLException;
}
