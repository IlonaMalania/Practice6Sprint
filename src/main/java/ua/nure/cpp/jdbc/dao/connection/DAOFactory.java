package ua.nure.cpp.jdbc.dao.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ua.nure.cpp.jdbc.dao.collection.CollectionLDAO;
import ua.nure.cpp.jdbc.dao.collection.PatientService;

import javax.naming.ConfigurationException;

@Component
public class DAOFactory {

    DAOConfig config;

    public static PatientDao getDAOInstance(TypeDAO type) {
        PatientDao dao = null;
        if (type == TypeDAO.MySQL) {
            dao = new PatientService(new DAOConfig("MySQL", "jdbc:mysql://127.0.0.1:3306/Polyclinics",
                    "root", "ilona2004"));
        }
        if (type == TypeDAO.COLLECTION) {
            dao = new CollectionLDAO();
        }
        return dao;
    }

    @Bean
    public PatientDao getDAOInstance(DAOConfig config) {
        if (TypeDAO.MySQL.name().equalsIgnoreCase(config.getType())) {
            return new PatientService(config);
        }
        if (TypeDAO.COLLECTION.name().equalsIgnoreCase(config.getType())) {
            return new CollectionLDAO();
        }
        throw new RuntimeException(new ConfigurationException("Unknown DAO type: " + config));
    }
}
