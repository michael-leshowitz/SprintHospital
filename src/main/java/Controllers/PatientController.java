package Controllers;

import DTO.UserDTO;
import Services.UserDetailsServiceImpl;
import models.Users;
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
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping("/dashboard")
    public ModelAndView userDashboard() {
        return new ModelAndView("patient-dashboard");
    }

    @RequestMapping(value="/patient/app-creation")
    public ModelAndView adminLoginProcessing() {
        return new ModelAndView("patient-create-appointment");
    }
}
