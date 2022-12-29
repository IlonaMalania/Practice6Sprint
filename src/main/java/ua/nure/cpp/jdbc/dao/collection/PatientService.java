package ua.nure.cpp.jdbc.dao.collection;

import ua.nure.cpp.jdbc.dao.connection.PatientDao;
import ua.nure.cpp.jdbc.dao.connection.DAOConfig;
import ua.nure.cpp.jdbc.entity.PatientCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PatientService  implements PatientDao {

    private final String url;
    private final Properties dbProps = new Properties();
    private Connection connection;



    public PatientService(DAOConfig config) {
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
    public void add(PatientCard patient) throws SQLException {
        PreparedStatement preparedStatement = null;
        connection = getConnection(false);

        String sql = "INSERT INTO Patient_card (Code_patient, Name, Date_of_birth, Gender, Address, Phone_number, Family_doctor) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,  (int) Math.random());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getDateOfBirth());
            preparedStatement.setInt(4, patient.getGender());
            preparedStatement.setString(5, patient.getAddress());
            preparedStatement.setString(6, patient.getPhoneNumber());
            preparedStatement.setInt(7, patient.getFamilyDoctor());


            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public PatientCard getByIndex(int index) throws SQLException {
        PreparedStatement preparedStatement = null;

        connection = getConnection(false);
        String sql = "SELECT Code_patient, Name, Date_of_birth, Gender, Address, Phone_number, Family_doctor FROM Patient_card WHERE Code_patient=?";

        PatientCard patient = new PatientCard();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, index);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                patient.setCodePatient(resultSet.getInt("Code_patient"));
                patient.setName(resultSet.getString("Name"));
                patient.setDateOfBirth(resultSet.getString("Date_of_birth"));
                patient.setGender(resultSet.getInt("Gender"));
                patient.setAddress(resultSet.getString("Address"));
                patient.setPhoneNumber(resultSet.getString("Phone_number"));
                patient.setFamilyDoctor(resultSet.getInt("Family_doctor"));
                preparedStatement.executeQuery();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
//                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }
        return patient;
    }

    @Override
    public List<PatientCard> getAll() throws SQLException {
        List<PatientCard> patientCardList = new ArrayList<>();

        connection = getConnection(false);
        String sql = "SELECT Code_patient, Name, Date_of_birth, Gender, Address, Phone_number, Family_doctor FROM Patient_card";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PatientCard patient = new PatientCard();
                patient.setCodePatient(resultSet.getInt("Code_patient"));
                patient.setName(resultSet.getString("Name"));
                patient.setDateOfBirth(resultSet.getString("Date_of_birth"));
                patient.setGender(resultSet.getInt("Gender"));
                patient.setAddress(resultSet.getString("Address"));
                patient.setPhoneNumber(resultSet.getString("Phone_number"));
                patient.setFamilyDoctor(resultSet.getInt("Family_doctor"));

                patientCardList.add(patient);
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
        return patientCardList;
    }

    @Override
    public void update(PatientCard patientCard) throws SQLException {

        connection = getConnection(false);
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Patient_card SET Code_patient=?, Name=?, Date_of_birth=?, Gender=?, Address=?, Phone_number=?, Family_doctor=? WHERE Code_patient=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, patientCard.getCodePatient());
            preparedStatement.setString(2, patientCard.getName());
            preparedStatement.setInt(3, patientCard.getGender());
            preparedStatement.setInt(4, patientCard.getFamilyDoctor());
            preparedStatement.setString(5, patientCard.getAddress());
            preparedStatement.setString(6, patientCard.getDateOfBirth());
            preparedStatement.setString(7, patientCard.getPhoneNumber());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
//                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }

    }

    @Override
    public void delete(PatientCard patientCard) throws SQLException {
        PreparedStatement preparedStatement = null;
        connection = getConnection(false);
        String sql = "DELETE FROM Patient_card WHERE Code_patient=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, patientCard.getCodePatient());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
//                preparedStatement.close();
            }
//            if (connection != null) {
//                connection.close();
//            }
        }

    }
    }


