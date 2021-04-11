package com.example.demo;

import DAO.GenericHibernatedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import models.Patient;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

@Autowired
private PatientRepository patientRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Patient> getAllPatient() {
        // This returns a JSON or XML with the users
        return patientRepository.findAll();
    }
}
