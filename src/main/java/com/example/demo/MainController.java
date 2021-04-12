package com.example.demo;

import DAO.GenericHibernatedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import models.Patient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

@Autowired
    private GenericHibernatedDAO<Patient> rep;

//
    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Patient> getAllPatient() {
        // This returns a JSON or XML with the users
        return rep.findAll();
    }

    @RequestMapping("/home")
    public ModelAndView home(Patient patient){
        ModelAndView mv = new ModelAndView();
        mv.addObject("patient", patient);
        mv.setViewName("home");
        return mv;
    }
}
