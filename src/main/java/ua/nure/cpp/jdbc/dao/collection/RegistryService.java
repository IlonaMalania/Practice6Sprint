package ua.nure.cpp.jdbc.dao.collection;

import ua.nure.cpp.jdbc.dao.connection.RegistryDao;
import ua.nure.cpp.jdbc.dao.connection.DAOConfig;
import ua.nure.cpp.jdbc.entity.Registry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RegistryService implements RegistryDao {

    private final String url;
    private final Properties dbProps = new Properties();
    private Connection connection ;



    public RegistryService(DAOConfig config) {
        url = config.getUrl();
        dbProps.setProperty("user", config.getUser());
        dbProps.setProperty("password", config.getPassword());
    }


    public Connection getConnection() throws SQLException {
        return getConnection(true);
    }

    private Connection getConnection(boolean autoCommit) throws SQLException {
        Connection con = DriverManager.getConnection(url, dbProps);
        con.setAutoCommit(autoCommit);
        return con;
    }

    @Override
    public void add(Registry appointment) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO Registry (Date_time, Doctor, Patient, ID) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, appointment.getDateTime());
            preparedStatement.setInt(2, appointment.getDoctor());
            preparedStatement.setInt(3, appointment.getPatient());
            preparedStatement.setInt(4, appointment.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }
    }

    @Override
    public Registry getByIndex(int index) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT Date_time, Doctor, Patient, ID FROM Registry WHERE ID=?";

        Registry appointment = new Registry();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, index);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                appointment.setDateTime(resultSet.getString("Date_time"));
                appointment.setDoctor(resultSet.getInt("Doctor"));
                appointment.setPatient(resultSet.getInt("Patient"));
                appointment.setId(resultSet.getInt("ID"));
                preparedStatement.executeQuery();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }
        return appointment;
    }

    @Override
    public List<Registry> getAll() throws SQLException {
        List<Registry> registryList = new ArrayList<>();

        String sql = "SELECT Date_time, Doctor, Patient, ID FROM Registry";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Registry appointment = new Registry();
                appointment.setDateTime(resultSet.getString("Date_time"));
                appointment.setDoctor(resultSet.getInt("Doctor"));
                appointment.setPatient(resultSet.getInt("Patient"));
                appointment.setId(resultSet.getInt("ID"));
                registryList.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }
        return registryList;
    }

    @Override
    public void update(Registry appointment) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Registry SET Date_time=?, Doctor=?, Patient=?, ID=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, appointment.getDateTime());
            preparedStatement.setInt(2, appointment.getDoctor());
            preparedStatement.setInt(3, appointment.getPatient());
            preparedStatement.setInt(4, appointment.getId());
            preparedStatement.setInt(5, appointment.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }
    }

    @Override
    public void delete(Registry appointment) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM Registry WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, appointment.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }

    }
    }

