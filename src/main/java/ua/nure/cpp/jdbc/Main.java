package ua.nure.cpp.jdbc;

import java.sql.SQLException;
import java.util.List;

import ua.nure.cpp.jdbc.dao.connection.PatientDao;
import ua.nure.cpp.jdbc.dao.collection.DoctorsService;
import ua.nure.cpp.jdbc.dao.collection.PatientService;
import ua.nure.cpp.jdbc.dao.collection.RegistryService;
import ua.nure.cpp.jdbc.dao.connection.DAOFactory;
import ua.nure.cpp.jdbc.dao.connection.TypeDAO;
import ua.nure.cpp.jdbc.entity.*;

public class Main {
	static DoctorsService doctorsService;
	static PatientService patientService;
	static RegistryService registryService;

	static AllDoctors doctors;
	static PatientCard patientCard;
	static Registry registry;

	public static void main(String[] args) throws SQLException {
//		System.out.println("Hello world!");
//		doctorsService = new DoctorsService();
		PatientDao dao = DAOFactory.getDAOInstance(TypeDAO.MySQL);
//		registryService = new RegistryService();

//        dao.add(new PatientCard(2, "Kamandara", "2020.01.01", 1,
//				"Kharkiv" , "3809954242323", 16));
		System.out.println("dao = " + dao.getByIndex(30)) ;
////        System.out.println(" ");
////        add();
//		System.out.println(" ");
//		getByIndex();
//        System.out.println(" ");
//        update();
//        System.out.println(" ");
//        delete();
	}


	public static void getAllData() {
		try {
			List<AllDoctors> addressList = doctorsService.getAll();
			for (AllDoctors e : addressList) {
				System.out.println("addressList = " + e.toString());
			}
			System.out.println(" ");

			List<PatientCard> patientCard1 = patientService.getAll();
			for (PatientCard e : patientCard1) {
				patientCard = new PatientCard(e.getCodePatient(), e.getName(),
						e.getDateOfBirth(), e.getGender(), e.getAddress(), e.getPhoneNumber(), e.getFamilyDoctor());
				System.out.println("patient = " + e.toString());
			}
			System.out.println(" ");

			List<Registry> registryList = registryService.getAll();
			for (Registry e : registryList) {
				registry = new Registry(e.getDateTime(), e.getDoctor(), e.getPatient(), e.getId());
				System.out.println("registry = " + e.toString());
			}
			System.out.println(" ");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
//
//	public static void add() throws SQLException {
//		doctors = new AllDoctors();
//		doctors.setName("Nikola");
//		doctors.setCode(35);
//		doctors.setSpecialty(2);
//		doctorsService.add(doctors);
//
//		patientCard = new PatientCard();
//		patientCard.setFamilyDoctor(16);
//		patientCard.setCodePatient(35);
//		patientCard.setPhoneNumber("+380993084798");
//		patientCard.setAddress("Kharkiv");
//		patientCard.setGender(1);
//		patientCard.setDateOfBirth("2004-12-07");
//		patientCard.setName("Jane");
//		patientService.add(patientCard);
//
//		registry = new Registry();
//		registry.setId(24);
//		registry.setDoctor(35);
//		registry.setDateTime("2022-12-12");
//		registry.setPatient(35);
//		registryService.add(registry);
//
//	}
//
//	public static void getByIndex() throws SQLException {
//
//		doctors = doctorsService.getByIndex(10);
//		System.out.println("doctors = " + doctors);
//		patientCard = patientService.getByIndex(1);
//		System.out.println("patientCard = " + patientCard);
//		registry = registryService.getByIndex(1);
//		System.out.println("registry = " + registry);
//	}
//
//	public static void update() throws SQLException {
//		registryService.update(registry);
//	}
//
//	public static void delete() throws SQLException {
//		registryService.delete(registry);
//	}

}