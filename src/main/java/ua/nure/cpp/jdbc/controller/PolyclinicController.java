package ua.nure.cpp.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.nure.cpp.jdbc.dao.connection.DoctorsDao;
import ua.nure.cpp.jdbc.dao.connection.PatientDao;
import ua.nure.cpp.jdbc.dao.collection.PatientService;
import ua.nure.cpp.jdbc.dao.connection.DAOFactory;
import ua.nure.cpp.jdbc.dao.connection.TypeDAO;
import ua.nure.cpp.jdbc.entity.PatientCard;
import ua.nure.cpp.jdbc.form.AddPatientForm;
import ua.nure.cpp.jdbc.form.DeletePatientForm;
import ua.nure.cpp.jdbc.form.GetPatientByIndexForm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PolyclinicController {

    private PatientDao patientDao = DAOFactory.getDAOInstance(TypeDAO.COLLECTION);
//    private PatientDao patientDao = DAOFactory.getDAOInstance(TypeDAO.MySQL);


    @RequestMapping(value = {"/", "/patients"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String showAllPatients(Model model) throws SQLException {
        List<PatientCard> list = patientDao.getAll();
        model.addAttribute("allPatients", list);
        return "patientsPage";
    }

    @GetMapping(value = {"/addPatients"})
    public String showAddPatientView(Model model) {
        AddPatientForm addPatientForm = new AddPatientForm();
        model.addAttribute("addPatientForm", addPatientForm);
        return "addPatientPage";
    }

    @PostMapping(value = {"/addPatients"})
    public String addPatient(Model model, AddPatientForm addPatientForm) throws SQLException {
        // validate adStudentForm object
        patientDao.add(new PatientCard(0, addPatientForm.getName(), addPatientForm.getDateOfBirth(), addPatientForm.getGender(),
                addPatientForm.getAddress(), addPatientForm.getPhoneNumber(), addPatientForm.getFamilyDoctor()));
        return "redirect:/patients";

    }

    @GetMapping(value = {"/deletePatientByIndex"})
    public String showDeletePatientView(Model model) {
        DeletePatientForm deletePatientForm = new DeletePatientForm();
        model.addAttribute("deletePatientForm", deletePatientForm);
        return "deletePatientByIndexPage";
    }

    @PostMapping(value = {"/deletePatientByIndex"})
    public String deletePatient(Model model, DeletePatientForm deletePatientForm) throws SQLException {
        patientDao.delete(patientDao.getByIndex(deletePatientForm.getCodePatient()));
        return "redirect:/patients";
    }

    @GetMapping(value = {"/getPatientByIndex"})
    public String showGetPatientByIndexView(Model model) {
        GetPatientByIndexForm getPatientByIndexForm = new GetPatientByIndexForm();
        model.addAttribute("getPatientByIndexForm", getPatientByIndexForm);
        return "getPatientByIndexPage";
    }

    @PostMapping(value = {"/getPatientByIndex"})
    public String getPatientByIndexGroup(Model model, GetPatientByIndexForm getPatientByIndexForm) throws SQLException {
        PatientCard patient = patientDao.getByIndex(getPatientByIndexForm.getCodePatient());
        List<PatientCard> list = new ArrayList<>();
        list.add(patient);
        model.addAttribute("allPatients", list);
        return "patientsPage";
    }

}