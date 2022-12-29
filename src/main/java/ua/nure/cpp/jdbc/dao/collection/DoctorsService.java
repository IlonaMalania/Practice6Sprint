package ua.nure.cpp.jdbc.dao.collection;

import ua.nure.cpp.jdbc.dao.connection.DoctorsDao;
import ua.nure.cpp.jdbc.dao.connection.DAOConfig;
import ua.nure.cpp.jdbc.entity.AllDoctors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DoctorsService implements DoctorsDao {

    private Connection connection;

    private final String url;
    private final Properties dbProps = new Properties();



    public DoctorsService(DAOConfig config) {
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
    public void add(AllDoctors doctors) throws SQLException {

        PreparedStatement preparedStatement = null;

        connection = getConnection(false);
        String sql = "INSERT INTO All_doctors (Code, Name, Specialty) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, doctors.getCode());
            preparedStatement.setString(2, doctors.getName());
            preparedStatement.setInt(3, doctors.getSpecialty());

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
    public AllDoctors getByIndex(int index) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT Code, Name, Specialty FROM All_doctors WHERE Code=?";

        AllDoctors doctors = new AllDoctors();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, index);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctors.setCode(resultSet.getInt("Code"));
                doctors.setName(resultSet.getString("Name"));
                doctors.setSpecialty(resultSet.getInt("Specialty"));
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
        return doctors;
    }

    @Override
    public List<AllDoctors> getAll() throws SQLException {
        List<AllDoctors> doctorsList = new ArrayList<>();

        String sql = "SELECT Code, Name, Specialty FROM All_doctors";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                AllDoctors doctors = new AllDoctors();
                doctors.setCode(resultSet.getInt("Code"));
                doctors.setName(resultSet.getString("Name"));
                doctors.setSpecialty(resultSet.getInt("Specialty"));

                doctorsList.add(doctors);
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
        return doctorsList;
    }

    @Override
    public void update(AllDoctors doctors) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE All_doctors SET Code=?, Name=?, Specialty=? WHERE Code=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, doctors.getCode());
            preparedStatement.setString(2, doctors.getName());
            preparedStatement.setInt(3, doctors.getSpecialty());

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
    public void delete(AllDoctors doctors) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM All_doctors WHERE Code=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, doctors.getCode());
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
