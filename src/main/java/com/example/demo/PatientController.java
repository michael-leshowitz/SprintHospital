package com.example.demo;

import DTO.PatientDTO;
import Services.PatientService;
import models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/patient")
@ComponentScan("Configuration")
@ComponentScan("Services")
public class PatientController {

    @Autowired
private PatientService patientService;

    @RequestMapping("login")
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("patient-login");
        return mv;
    }

    @RequestMapping("registration")
    public ModelAndView registration() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("registration");
        return mv;
    }

    @GetMapping(path="registration")
    public String registrationForm(WebRequest request, Model model) {
        PatientDTO patientDto = new PatientDTO();
        model.addAttribute("patient", patientDto);
        return "registration";
    }

    @RequestMapping(value="registration", method= RequestMethod.POST)
    public ModelAndView registerPatientAccount(@ModelAttribute("patient") PatientDTO patientDTO,
            HttpServletRequest request,
            Errors errors) {
        try {
            Patient registered = patientService.registerNewPatientAccount(patientDTO);
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView();
            System.out.println(patientDTO.getFirstName());
            mav.addObject("patient", patientDTO);
            mav.addObject("error", e.getMessage());
            mav.setViewName("registration");
            return mav;
        }
        return new ModelAndView("successRegister", "patient", patientDTO);
    }
}
